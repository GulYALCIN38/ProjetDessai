 # ACCEPTANCE CRITERIA
 # 1.Les elements de navbar(Home, Certification, Abaut us, Joining us, Contact, Term and Conditions of use & GDPR,
  # Code éthique) doivent être visibles et fonctionnels
  # 2. CONTACT -> Tous les champs obligatoires doivent être remplis pour pouvoir envoyer un e-mail.
 @diagdev
 Feature:Check Titles et Créer un contact(test robustesse pour le lien de contact)

   Background: Visite le site
     Given l'utilisateur visite le site de "http://diagdev.com"

   Scenario Outline: TC_002 TEST ROBUSTESSE(negatif) Un contact ne peut pas être créé en laissant les champs obligatoires vides.
     When l'utilisateur clique sur le link de Contact
     And l'utilisateur remplit le formulaire "<First Name>","<Last Name>","<Position>","<Company or institution name>","<Please detail your request>","<City and State>","<Email>"
     And l'utilisateur  clique Send button
     Then utilisateur vérifie que le message d'avertissement "Forms contains errors. Please check your informations." apparaît sur la surface rouge
     Examples:
       | First Name | Last Name | Position     | Company or institution name | Please detail your request   | City and State | Email             |
       |            | YALCIN    | test qa      | talenttech                  | Lorem ipsum dolor sit amet   | Montpellier    | gulfen3@gmail.com |
       | gul        |           | dev          | laboris                     | consectetur adipisicing elit | Montpellier    | gul@gmail.com     |
       | gul        | YALCIN    |              | Excepteur                   | sed do eiusmod tempor        | Montpellier    | yalcin@gmail.com  |
       | gul        | YALCIN    | SCRUM MASTER |                             | quis nostrud exercitation ul | Montpellier    | kaya@gmail.com    |
       | gul        | YALCIN    | PO           | officia                     |                              | Montpellier    | zelu@gmail.com    |
       | gul        | YALCIN    | architect    | voluptate                   | Duis aute irure dolor in     |                | umut@gmail.com    |
       | gul        | YALCIN    | architect    | voluptate                   | Duis aute irure dolor in     | Montpellier    |                   |
