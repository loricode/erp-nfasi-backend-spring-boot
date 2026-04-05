#!/bin/bash

echo "Compilando proyecto..."
mvn clean package || { echo "Error en Maven"; exit 1; }

echo "Eliminando contenedor antiguo..."
docker rm -f erp-core-container 2>/dev/null || true

echo "Construyendo imagen Docker..."
docker build -t erp-core . || { echo "Error al construir imagen"; exit 1; }

echo "Ejecutando contenedor..."
docker run -d -p 8082:8082 --name erp-core-container erp-core
echo "¡Listo! Contenedor erp-core-container ejecutándose en el puerto 8082"