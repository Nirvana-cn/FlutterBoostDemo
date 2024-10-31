## 基于Tensorflow Lite的MNIST手写数字识别

工程不包含模型训练过程，仅使用已训练好的模型进行数字识别。

### 基础配置

添加依赖

```
implementation 'org.tensorflow:tensorflow-lite:2.5.0'
```

避免模型被压缩

```
aaptOptions {
    noCompress "tflite"
    noCompress "lite"
}
```

### 参考

MNIST-TFLite：[>>>点我进入](https://github.com/frogermcs/MNIST-TFLite)