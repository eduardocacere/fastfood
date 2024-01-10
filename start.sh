#!/bin/bash

echo "Iniciando Applicação"


echo "Gerando build da imagem"

'mvn clean package'

#packageΩecho "gerando imagem"

#docker build -t fastfood:latest .


