#!/bin/bash

echo "开始运行"
mvn clean package

echo "Exam3程序运行结果："
java -jar ./target/Exam3.jar 601006



