# Folosește o imagine Docker care include Maven și JDK pentru etapa de construcție
FROM maven:3.8.4-openjdk-17 as build

# Setează directorul de lucru în container pentru etapa de construcție
WORKDIR /build

# Asigură-te că copiezi întregul director kafka-producer-v1, care trebuie să includă pom.xml și directorul src
COPY ./kafka-producer-v1 ./kafka-producer-v1

# Schimbă directorul de lucru în directorul modulului care trebuie construit
WORKDIR /build/kafka-producer-v1

# Construiește modulul, sărind peste teste
RUN mvn clean package -DskipTests

# Folosește o nouă imagine de bază pentru a rula aplicația, pentru a reduce dimensiunea imaginii finale
FROM openjdk:17-jdk-slim

# Setează directorul de lucru în container pentru aplicația rulabilă
WORKDIR /app

# Copiază fișierul jar construit în etapa anterioară în directorul de lucru al aplicației
COPY --from=build /build/kafka-producer-v1/target/kafka-producer-v1-0.0.1.jar /app/kafka-producer-v1.jar

# Expune portul pe care rulează aplicația
EXPOSE 8080

# Comandă pentru a rula aplicația
ENTRYPOINT ["java", "-jar", "kafka-producer-v1.jar"]