@Astek
Feature:Postule_pour_un_emploi_chez_Astek

  Scenario:TC_01_recherche_un_post_sur_logiciel(CAS NOMINAL)
    Given utilisateur visite "site Astek"
    When utilisateur  clicque sur le bouton de POSTULER
    And utilisateur clicque sur le bouton de CDI
    And utilisateur clicque sur le bouton de Ingenierie
    And utilisateur clicque sur le bouton de Acceder a nos offres d'emploi
    And utilisateur envoye un mot-cles a le textbox de mot-cles
    Then utilisateur rempli ses informations pour soumettre




