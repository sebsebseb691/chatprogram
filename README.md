# chatprogram

Skapa server connection klass som bara ansvarar över connection Singleton

View lägger till sig själv som listner i model så chatroom uppdateras när model uppdateras

Få upp så man kan chatta med sig själv

Försök få upp en bild av hur servern ska fungera med connections, TCP socket, behöver inte vara ansluten till resten av programmet


Göra så client har lägre koppling genom interface

Ska lyssnare bli tillagda i controller eller genom view?
Finns det något sätt att undvika att serverlist view tar in controller?
Behöver setters och getters vara med i interface?
Är det okej att ha en private constructor som gör något? -ModelsFacade