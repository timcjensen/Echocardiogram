# Multilayer perceptron classifier

from sklearn.neural_network import MLPClassifier
from sklearn.model_selection import KFold
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import confusion_matrix, classification_report
from sklearn.model_selection import GridSearchCV
import numpy as np
from joblib import dump

echo = np.loadtxt(r'data/Echocardiogram_Cleaned.csv', delimiter=',', skiprows=1)
data = np.loadtxt(r'data/data.csv', delimiter=',', skiprows=1)

# Model parameters determined using GridSearchCV
clf = MLPClassifier(activation='tanh', alpha=0.0001, hidden_layer_sizes=(1, 1), learning_rate='constant', solver='sgd')

X = data[:, 0:3]
y = data[:, -1]

#StandardScaler - preprocessing that standardizes dataset
scaler = StandardScaler()
scaler.fit(X)
X = scaler.transform(X)

tp1 = 0
fp1 = 0
tn1 = 0
fn1 = 0

#10-fold cross validation
kf = KFold(n_splits=10)
for train, test in kf.split(data):
	clf.fit(X[train], y[train])
	predictions = clf.predict(X[test])
	print(clf.score(X[test], y[test]))
	conf_matrix = confusion_matrix(y[test], predictions, labels=[0,1])
	print(conf_matrix)

	print(classification_report(y[test], predictions))

	tn, fp, fn, tp = conf_matrix.ravel()
	tn1 += tn
	fp1 += fp
	fn1 += fn
	tp1 += tp

testing_set = np.loadtxt(r'data/testing_set.csv', delimiter=',')

predictions = clf.predict(testing_set[:, 0:3])
print(clf.score(testing_set[:, 0:3], testing_set[:,-1]))
conf_matrix = confusion_matrix(testing_set[:,-1], predictions, labels=[0, 1])
print(conf_matrix)

print(classification_report(testing_set[:,-1], predictions))

# dump trained model to file
dump(clf, 'mlp.joblib')

# # GridSearchCV to find best model parameters
# parameter_space = {
# 	'hidden_layer_sizes': [(1,1), (2,2), (3,3), (4,4)],
# 	'activation': ['tanh', 'relu', 'identity', 'logistic'],
# 	'solver': ['sgd', 'adam', 'lbfgs'],
# 	'alpha': [0.0001, 0.05, 1e-05],
# 	'learning_rate': ['constant', 'adaptive', 'invscaling'],
# }
#
# mlp = GridSearchCV(clf, parameter_space, n_jobs=-1, cv=3)
#
# mlp.fit(X, y)
# print('Best params:', mlp.best_params_)
