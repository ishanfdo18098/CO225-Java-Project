csvFile = open("CryptoCurrency.csv")

isFirstLine = True
for eachLine in csvFile:
    if isFirstLine:
        isFirstLine = False
        continue
    splitted = eachLine.split(",")
    name = splitted[1]
    print(f"<item>{name}</item>")