import pandas as pd

data = pd.read_csv(r"C:\Users\yb3236rv\OneDrive - MNSCU\Machine Learning Term Project\Code\Echocardiogram\data\Echocardiogram_Cleaned.csv")

# Univariate Selection
from sklearn.feature_selection import SelectKBest
from sklearn.feature_selection import chi2
from sklearn.ensemble import ExtraTreesClassifier
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np

X = data.iloc[:,0:7]  #independent columns
y = data.iloc[:,-1]    #target column i.e price range
#apply SelectKBest class to extract top 10 best features

bestfeatures = SelectKBest(score_func=chi2, k=7)
fit = bestfeatures.fit(X,y)
dfscores = pd.DataFrame(fit.scores_)
dfcolumns = pd.DataFrame(X.columns)
#concat two dataframes for better visualization
featureScores = pd.concat([dfcolumns,dfscores],axis=1)
featureScores.columns = ['Features','Score']  #naming the dataframe columns
print(featureScores.nlargest(7,'Score'))  #print 10 best features

# Feature Importance
feature_importance = []

for i in range(250):
	model = ExtraTreesClassifier()
	model.fit(X, y)
	model_feature_importance = model.feature_importances_
	print(model_feature_importance) #use inbuilt class feature_importances of tree based classifiers
	feature_importance.append(model_feature_importance)

feature_importance = np.array(feature_importance)

#plot graph of feature importances for better visualization
avg = np.mean(feature_importance, axis=0)
feat_importances = pd.Series(avg, index=X.columns)
feat_importances.nlargest(10).plot(kind='barh')
plt.xlabel('Importance Score')
plt.ylabel('Feature')
plt.title('Feature Importance')

plt.show()

# Correlation Matrix with Heatmap
corrmat = data.corr()
top_corr_features = corrmat.index
plt.figure(figsize=(8,8))
#plot heat map
g=sns.heatmap(data[top_corr_features].corr(),annot=True,cmap="RdYlGn")
# fix for mpl bug that cuts off top/bottom of seaborn viz
b, t = plt.ylim() # discover the values for bottom and top
b += 0.5 # Add 0.5 to the bottom
t -= 0.5 # Subtract 0.5 from the top
plt.ylim(b, t) # update the ylim(bottom, top) values
plt.title('Correlation Matrix')
plt.show() # ta-da!
