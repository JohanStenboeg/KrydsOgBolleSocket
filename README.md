# Kryds Og Bolle - Socket programmering  

> Disclaimer: Når man vil spille spillet, skal man gå ind og ændre IP-addressen i Java klassen 'CapClient.java'. 

> Dette gør du her:

![](https://i.imgur.com/fpAWr7e.png)

Det er vigtigt at alle, der skal spille spillet er forbundet til serveren. Det er derfor, du skal ændre IP'en i programmet, til den IP, serveren er hostet på, da du ellers ikke kan forbinde til den, og derfor ikke kan spille.

Når der er to klienter forbundet til serveren, kan spillet starte. Først bliver begge klienter bedt om, at indtaste et navn. Dette gør de ved at skrive det ønskede navn i konsollen. Afhængigt af hvem der indtaster deres navn først, bliver de tildelt kryds eller bolle. Kryds starter.

Spillet starter ved, at spiller 1 (Kryds) indtaster sit træk i konsollen. Da vores spil er lavet ud fra et array, og der er 9 pladser i arrayet, skal spilleren blot indtaste sit træk for den ønskede plads således: 0, 1, 2, 3, 4, 5, 6, 7 eller 8. Grundet at det er 0-8, og ikke 1-9, er at et array starter på plads 0[spilleplads 1] og slutter på plads 8[spilleplads 9]. 

Når en spiller placere sin brik, på en tom plads, vil spillepladen blive vist i konsollen, med brikken på spillepladen. 

Når en spiller prøver at placere sin brik på en plads, der allerede er optaget, vil turen gå tabt, og gå videre til den anden spiller.

Når en spiller prøver at placere sin brik på en plads, der ikke eksistere på pladen (eksempelvis hvis de placere den på en plads, der er ude for spillepladen, som plads 10, eller -1) vil de blive bedt om, at lave et nyt træk. 

Hvis en spiller når til et punkt, hvor de har 3-på-stribe inden modspilleren har, vil denne blive annonceret som vinder i konsollen, og spillet afslutter. Man skal selv lukke programmet. 





    
      
        
        
# For i år bliver det endnu vildere
![](https://i.ytimg.com/vi/PJDiYiDXpE4/maxresdefault.jpg)
