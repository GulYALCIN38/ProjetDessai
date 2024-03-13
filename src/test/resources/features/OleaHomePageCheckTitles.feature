@olea
Feature:Check Titles et demander une démo(test robustes)

  Background: Visite le site
    Given L'utilisateur visite le site de "https://www.olea-medical.com/fr/"
    When  L'utilisateur ferme Popup

  Scenario:TC_001 Les elements de navbar(Pourquoi olea medical?, Solutions, Ressources, A propos d'Olea Medical,
  demander une démo, icon de connexion, FR) doivent être visible

    Then l'utilisateur vérifie que les champs concernés sont visibles

  Scenario:TC_002 Les elements de navbar(Pourquoi olea medical?, Solutions, Ressources, A propos d'Olea Medical,
  demander une démo, icon de connexion, FR) doivent être fonctionnels

    Then l'utilisateur vérifie que les champs concernés sont fonctionnels

  Scenario Outline: TC_003 la demande de démo ne peut être créées sans remplir les champs obligatoires.

    And l'utilisateur clique sur la demande de démo
    And l'utilisateur remplit le formulaire avec des valeurs valides "<prénom>", "<nom>", "<Instution>"
    Then l'utilisateur vérifie que le message d'avertissement apparaît:"Veuillez remplir tous les champs requis."
    Examples:
      | prénom | nom     | Instution                       |
      |        | Grifart | Fondation Combattre la Leucémie |
      | Gul    |         | protection environnementale     |
      | Gul    | Yalcin  |                                 |
