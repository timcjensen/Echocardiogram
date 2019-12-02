import pylab as pl
import numpy as np
import pandas as pd

#age.at.heart.attack,pericardial.effusion,fractional.shortening,epss,lvdd,wall.motion.score,wall.motion.index,target
#age.at.heart.attack,lvdd,wall.motion.score

echo = np.loadtxt(r'data/Echocardiogram_Cleaned.csv', delimiter=',', skiprows=1)
teset = np.loadtxt(r'data/testing_set.txt', delimiter=',')
tset = np.loadtxt(r'data/training_set.txt', delimiter=',')

