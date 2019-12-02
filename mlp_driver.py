from sklearn.neural_network import MLPClassifier
from joblib import load
import sys

clf = load('mlp.joblib')

def predict(age, lvdd, wms):
	prob = clf.predict([[age, lvdd, wms]])
	return prob

age = float(sys.argv[1])
lvdd = float(sys.argv[2])
wms = float(sys.argv[3])

print(predict(age, lvdd, wms)[0])
