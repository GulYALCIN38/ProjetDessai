@olea
Feature:Check Titles et demander une démo(Cas nominal)
  Background: Visite le site
    Given L'utilisateur visite le site de "https://www.olea-medical.com/fr/"
    When  L'utilisateur ferme Popup

  Scenario:TC_001 Les elements de navbar(Pourquoi olea medical?, Solutions, Ressources, A propos d'Olea Medical,
  demander une démo, icon de connexion, FR) doivent être visible

    Then l'utilisateur vérifie que les champs concernés sont visibles

  Scenario:TC_002 Les elements de navbar(Pourquoi olea medical?, Solutions, Ressources, A propos d'Olea Medical,
  demander une démo, icon de connexion, FR) doivent être fonctionnels

    Then l'utilisateur vérifie que les champs concernés sont fonctionnels

    Scenario: TC_003 la demande de démo devrait pouvoir être créée(Cas nominal)





