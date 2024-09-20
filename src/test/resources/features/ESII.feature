 # ACCEPTANCE CRITERIA
  # 1.Les elements de navbar(Parcours visiteur, Solutions, Expertises, Distributeurs,À propos) doivent être visibles et fonctionnels
  # 2. Candidature spontanée -> Tous les champs obligatoires doivent être remplis pour pouvoir envoyer une candidature spontanée.
 Feature:Contrôles de title et Candidature spontanée

   Background: Visite le site
     Given l'utilisateur visite le site de "https://www.esii.com/"
     When l'utilisateur ferme Popup

   Scenario: TC_01 Les elements de navbar(Parcours visiteur, Solutions, Expertises, Distributeurs,À propos) doivent être visibles et fonctionnels

     Then L'utilisateur vérifie que les champs concernés sont visibles, fonctionnels
       | Parcours visiteur |
       | Solutions         |
       | Expertises        |
       | Distributeurs     |
       | À propos          |
     When l'utilisateur clique sur le lien de Candidature spontanée

   Scenario Outline:TC_02 TEST ROBUSTESSE(negatif) Une Candidature spontanée ne peut pas être envoyée en laissant les champs obligatoires vides. en laissant les champs obligatoires vides.
     When l'utilisateur clique sur le lien de Candidature spontanée
#     And l'utilisateur remplit le formulaire "<First Name>","<Last Name>","<Position>","<Company or institution name>","<Please detail your request>","<City and State>","<Email>"
#     And l'utilisateur  clique sur le Send button
#     Then utilisateur vérifie que le message d'avertissement "Forms contains errors. Please check your informations." apparaît sur la surface rouge
     Examples:
#       | First Name | Last Name | Position     | Company or institution name | Please detail your request   | City and State | Email             |
#       |            | YALCIN    | Test qa      | Talenttech                  | Lorem ipsum dolor sit amet   | Montpellier    | gulfen3@gmail.com |
#       | Gul        |           | Dev Backend  | Laboris                     | Consectetur adipisicing elit | Montpellier    | gul@gmail.com     |
#       | Gul        | YALCIN    |              | Excepteur                   | Sed do eiusmod tempor        | Montpellier    | yalcin@gmail.com  |
#       | Gul        | YALCIN    | SCRUM MASTER |                             | Quis nostrud exercitation ul | Montpellier    | kaya@gmail.com    |
#       | Gul        | YALCIN    | PO           | Officia                     |                              | Montpellier    | zelu@gmail.com    |
#       | Gul        | YALCIN    | Architect    | Voluptate                   | Duis aute irure dolor in     |                | umut@gmail.com    |
#       | Gul        | YALCIN    | TESTER       | START                       | Excepteur sint occaecat      | Montpellier    |                   |
#





