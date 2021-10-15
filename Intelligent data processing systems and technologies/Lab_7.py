import pandas as pd
from sklearn.model_selection import *
from sklearn.linear_model import *
from sklearn import *
import matplotlib.pyplot as plt
import numpy as np
import seaborn as sns

df=pd.read_csv("CSV/wine.csv")
df["quality"]=df["quality"].map({"good": 1, "bad": 0})
print(df.head())
X = df[["fixed acidity","volatile acidity","citric acid","residual sugar","chlorides"]] # Features
print(X.head())
y = df.quality # Target variable
print(y.head())


X_train,X_test,y_train,y_test=train_test_split(X,y,test_size=0.25,random_state=0)
# тренируем модель
logreg = LogisticRegression()

logreg.fit(X_train,y_train)

y_pred=logreg.predict(X_test)

cnf_matrix = metrics.confusion_matrix(y_test, y_pred)
#матрица сопряжённости
print(f"{cnf_matrix=}")


class_names=[0,1] # name  of classes
fig, ax = plt.subplots()
tick_marks = np.arange(len(class_names))
plt.xticks(tick_marks, class_names)
plt.yticks(tick_marks, class_names)
# create heatmap
sns.heatmap(pd.DataFrame(cnf_matrix), annot=True, cmap="YlGnBu" ,fmt='g')
ax.xaxis.set_label_position("top")
plt.tight_layout()
plt.title('Confusion matrix', y=1.1)
plt.ylabel('Actual label')
plt.xlabel('Predicted label')
plt.show()

print("Accuracy:",metrics.accuracy_score(y_test, y_pred))
print("Precision:",metrics.precision_score(y_test, y_pred))
print("Recall:",metrics.recall_score(y_test, y_pred))


y_pred_proba = logreg.predict_proba(X_test)[::,1]
fpr, tpr, _ = metrics.roc_curve(y_test,  y_pred_proba)
auc = metrics.roc_auc_score(y_test, y_pred_proba)
plt.plot(fpr,tpr,label="data 1, auc="+str(auc))
plt.legend(loc=4)
plt.show()



print("improve model")
X2 = df[["fixed acidity","volatile acidity","citric acid","residual sugar","chlorides","density","sulphates","alcohol"]] # Features
print(X2.head())
y2 = df.quality # Target variable
print(y2.head())


X_train2,X_test2,y_train2,y_test2=train_test_split(X2,y2,test_size=0.25,random_state=0)

logreg2 = LogisticRegression()

logreg2.fit(X_train2,y_train2)

y_pred2=logreg2.predict(X_test2)

cnf_matrix2 = metrics.confusion_matrix(y_test2, y_pred2)
#матрица сопряжённости
print(f"{cnf_matrix2=}")
class_names=[0,1] # name  of classes
fig, ax = plt.subplots()
tick_marks = np.arange(len(class_names))
plt.xticks(tick_marks, class_names)
plt.yticks(tick_marks, class_names)
# create heatmap
sns.heatmap(pd.DataFrame(cnf_matrix), annot=True, cmap="YlGnBu" ,fmt='g')
ax.xaxis.set_label_position("top")
plt.tight_layout()
plt.title('Confusion matrix', y=1.1)
plt.ylabel('Actual label')
plt.xlabel('Predicted label')
plt.show()
print("Accuracy:",metrics.accuracy_score(y_test2, y_pred2))
print("Precision:",metrics.precision_score(y_test2, y_pred2))
print("Recall:",metrics.recall_score(y_test2, y_pred2))

y_pred_proba2 = logreg2.predict_proba(X_test2)[::,1]
fpr2, tpr2, _2 = metrics.roc_curve(y_test2,  y_pred_proba2)
auc2 = metrics.roc_auc_score(y_test2, y_pred_proba2)
plt.plot(fpr,tpr,label="data 1, auc="+str(auc))
plt.plot(fpr2,tpr2,label="data 2Ы, auc="+str(auc2))
plt.legend(loc=4)
plt.show()
