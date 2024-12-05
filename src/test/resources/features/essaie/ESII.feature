 # ACCEPTANCE CRITERIA
  # 1.Les elements de navbar(Parcours visiteur, Solutions, Expertises, Distributeurs,À propos) doivent être visibles et fonctionnels
  # 2. Candidature spontanée -> Tous les champs obligatoires doivent être remplis pour pouvoir envoyer une candidature spontanée.

 @ESII
 Feature:Contrôles de title et Candidature spontanée

   Background: Visite le site
     Given l'utilisateur visite le site de "https://www.esii.com/"
     When l'utilisateur ferme Popup

   @ESII_TC_01
   Scenario: TC_01 Les elements de navbar(Parcours visiteur, Solutions, Expertises, Distributeurs,À propos) doivent être visibles et fonctionnels

     Then L'utilisateur vérifie que les champs concernés sont visibles, fonctionnels
       | Parcours visiteur |
       | Solutions         |
       | Expertises        |
       | Distributeurs     |
       | À propos          |

   Scenario Outline:TC_02 TEST ROBUSTESSE(negatif) Une Candidature spontanée ne peut pas être envoyée en laissant les champs obligatoires vides.
     When l'utilisateur clique sur le lien de Candidature spontané
     And  l'utilisateur remplit le formulaire "<Nom et prénom>","<E-mail>","<Téléphone>"
     And l'utilisateur télécharge un CV
     And L'utilisateur télécharge une lettre de motivation
     And L'utilisateur écrit un message
     And l'utilisateur  clique sur le checkbox RGPD
     And l'utilisateur clique sur le bouton de Envoyer
     Then utilisateur vérifie que le message d'avertissement rouge "Ce champ est nécessaire" apparaît


     Examples:
       | Nom et prénom | E-mail            | Téléphone  |
       | Gul YALCIN    |                   | 0658194363 |
       | Gul YALCIN    | gulfen3@gmail.com |            |






