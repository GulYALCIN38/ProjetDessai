# ACCEPTANCE CRITERIA
  # 1.Les button de navbar(Coptes & Cartes,Épargne, Assurances,Crédits) doivent être visibles et fonctionnels
  # 2.Les liens de navbar(Simulations & devis, Nos conseils,Espace Sociétaire,Banque en ligne) doivent être visibles et fonctionnels
  # 3. Contact  -> Tous les champs obligatoires doivent être remplis pour pouvoir être rappelé
@CreditAgricole
Feature:Contrôles de title et Contact

  Background: Visite le site
    Given l'utilisateur visite le site de "https://www.credit-agricole.fr/ca-languedoc/particulier.html"
    When l'utilisateur ferme popup

  @CreditAgricole_TC_01
  Scenario: TC_01 Les boutons de navbar(Coptes & Cartes,Épargne, Assurances,Crédits, Non conseils) doivent être visibles et fonctionnels

    Then L'utilisateur vérifie que les boutons concernés sont visibles et  fonctionnels
    Then L'utilisateur vérifie que les liens concernés sont visibles et  fonctionnels
      | Simulation & devis |
      | Espace Sociétaire  |
      | Banque en ligne    |

  Scenario Outline:TC_02 TEST ROBUSTESSE(negatif) Une demande de contact téléphonique ne peut être envoyée que si tous les champs obligatoires sont remplis
    And l'utilisateur clique sur icon de Contact
    And l'utilisateur clique sur Être rappelé
    And l'utilisateur complète le formulaire "<Nom>","<Prénom>","<Téléphone>", "<date>","<horaire>"
    And l'utilisateur  clique sur le  checkbox
    And l'utilisateur clique sur le bouton de valider
    Then utilisateur vérifie que le message davertissement  rouge "<Message>" saffiche


    Examples:
      | Nom    | Prénom | Téléphone  | date       | horaire | Message                                                        |
      | YALCIN | Gul    | 0658194362 | 13/12/2024 | 8.30    | Donnée obligatoire - Veuillez saisir votre numéro de téléphone |
#      | COUSTO | Magali | 0658194362 |            |         | Veuillez sélectionner une date dans le calendrier              |
#      | FABRE  | Nico   | 0658194360 | 14/12/2024 |         | Veuillez sélectionner un horaire                               |
#




