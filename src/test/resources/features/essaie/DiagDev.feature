 # ACCEPTANCE CRITERIA

  # 1. CONTACT -> Tous les champs obligatoires doivent être remplis pour pouvoir envoyer un e-mail.
 @diagdev
 Feature:Check Titles et Créer un contact(test robustesse pour le lien de contact)

   Background: Visite le site
     Given l'utilisateur visite le site de "http://diagdev.com"


   Scenario Outline: TC_001 TEST ROBUSTESSE(negatif) Un contact ne peut pas être créé en laissant les champs obligatoires vides.
     When l'utilisateur clique sur le lien de Contact
     And l'utilisateur remplit le formulaire "<First Name>","<Last Name>","<Position>","<Company or institution name>","<Please detail your request>","<City and State>","<Email>"
     And l'utilisateur  clique sur le Send button
     Then utilisateur vérifie que le message d'avertissement "Forms contains errors. Please check your informations." apparaît sur la surface rouge
     Examples:
       | First Name | Last Name | Position     | Company or institution name | Please detail your request   | City and State | Email             |
       |            | YALCIN    | Test qa      | Talenttech                  | Lorem ipsum dolor sit amet   | Montpellier    | gulfen3@gmail.com |
       | Gul        |           | Dev Backend  | Laboris                     | Consectetur adipisicing elit | Montpellier    | gul@gmail.com     |
       | Gul        | YALCIN    |              | Excepteur                   | Sed do eiusmod tempor        | Montpellier    | yalcin@gmail.com  |
       | Gul        | YALCIN    | SCRUM MASTER |                             | Quis nostrud exercitation ul | Montpellier    | kaya@gmail.com    |
       | Gul        | YALCIN    | PO           | Officia                     |                              | Montpellier    | zelu@gmail.com    |
       | Gul        | YALCIN    | Architect    | Voluptate                   | Duis aute irure dolor in     |                | umut@gmail.com    |
       | Gul        | YALCIN    | TESTER       | START                       | Excepteur sint occaecat      | Montpellier    |                   |
