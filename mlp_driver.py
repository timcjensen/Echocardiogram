from sklearn.neural_network import MLPClassifier
from joblib import load

clf = load('mlp.joblib')

def predict(age, lvdd, wms):
	prob = clf.predict_proba([[age, lvdd, wms]])
	print(prob[0,1])