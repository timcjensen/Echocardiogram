#Nearest Centroid Classification

from sklearn.neighbors import NearestCentroid
from sklearn.metrics import confusion_matrix
import numpy as np

echo = np.loadtxt(r'data/Echocardiogram_Cleaned.csv', delimiter=',', skiprows=1)
data = np.loadtxt(r'data/data.csv', delimiter=',', skiprows=1)

tp1 = 0
fp1 = 0
tn1 = 0
fn1 = 0

for _ in range(10):
	for _ in range(250):
		np.random.shuffle(echo)
		train_data = echo[10:]
		test_data = echo[:10]
		X = train_data[:,0:7]
		y = train_data[:,-1]
		neigh = NearestCentroid()
		neigh.fit(X, y)

		pred_targets = neigh.predict(test_data[:,0:7])
		test_targets = test_data[:,-1]

		conf_matrix = confusion_matrix(test_targets, pred_targets, labels=[0,1])
		#print(conf_matrix)

		tn, fp, fn, tp = conf_matrix.ravel()
		tn1 += tn
		fp1 += fp
		fn1 += fn
		tp1 += tp

print(tp1, fp1, tn1, fn1)
