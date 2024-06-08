@fdj
  # ACCEPTANCE CRITERIA
  # 1.Les elements de navbar(Tous les jeux, EuroDreams, Euromillions, Loto, illiko, Bingo Live,
  #   Keno, Résultats, jeu Responsable, Le Coin des Joueurs Paris Sportif - Loto Foot) doivent être visibles et fonctionnels
  # 2.Il doit s'agir d'un mot de passe comportant au minimum 8 caractères de string et
  # contenant 1 caractère spécial, 1 chiffre, 1 majuscule, 1 minuscule pour créer un compte.
Feature:Check Titles et Créer un compte(test robustesse et cas nominal pour le champ de mot de passe)

  Background: Visite le site
    Given l'utilisateur visite le site de "https://www.fdj.fr/"
    When  l'utilisateur ferme Popup

  @fdjscenario1
  Scenario:TC_001 Les elements de navbar(Tous les jeux, EuroDreams, Euromillions, Loto, illiko
  Bingo Live, Keno, Résultats, jeu Responsable, Le Coin des Joueurs Paris Sportif - Loto Foot) doivent être visible.

    Then L'utilisateur vérifie que les champs concernés sont visibles et fonctionnels


  Scenario Outline: TC_002 TEST ROBUSTESSE(negatif) Un compte ne peut pas être créé en saisissant un mot de passe invalide
  (sans caractère spécial @[]^_!"#$%&'()*+,-./:;{}<>=|~?
  moins de 8 caractère
  sans chiffre
  sans majuscule
  sans minuscule).

    And l'utilisateur clique sur le link de Créer un compte
    And l'utilisateur remplit le formulaire avec des valeurs valides "<email>", "<tel>"
    And l'utilisateur remplit le champ de mot de passe avec de valeur invalid "<mot de passe>"
    Then utilisateur vérifie que le message d'avertissement "Merci de respecter les critères ci-dessus" apparaît
    Examples:
      | email                   | mot de passe | tel        |
      | gulyalcin2022@gmail.com | Francais38   | 0658194363 |
      | yalcin2022@gmail.com    | Fdj38**      | 0658194363 |
      | gul2022@gmail.com       | Francais*    | 0658194363 |
      | gulyalcin2022@gmail.com | francais38*  | 0658194363 |
      | gulyalcin@gmail.com     | FRANCAIS38*  | 0658194363 |

  Scenario Outline: TC_003 "Happy scenario" (CAS NOMINAL) avec au format de mot de passe valid (
  avec 1 caractère spécial @[]^_!"#$%&'()*+,-./:;{}<>=|~?
  8 caractères minimum
  1 chiffre
  1 majuscule
  1 minuscule)

    And l'utilisateur clique sur le link de Créer un compte
    And l'utilisateur remplit le formulaire avec des valeurs valides "<email>", "<tel>"
    And l'utilisateur remplit le champ de mot de passe avec de valeur valid "<mot de passe>"
    Then l'utilisateur verifie quil passe à la deuxième étape de création de compte

    Examples:
      | email                   | mot de passe | tel        |
      | gulyalcin2022@gmail.com | Francais3*   | 0658194363 |

