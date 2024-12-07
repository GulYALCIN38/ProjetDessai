# ACCEPTANCE CRITERIA
  # 1.Les elements de navbar(ACCUEIL, À PROPOS, EXPERTISES, REJOIGNE-NOUS, CONTACT) doivent être visibles et fonctionnels
  # 2. Candidature spontanée -> Tous les champs obligatoires doivent être remplis pour pouvoir envoyer une candidature spontanée.

@Synanto
Feature:Contrôles de title et Candidature spontanée

  Background: Visite le site
    Given l'utilisateur visite le site de "https://synanto.fr/"

  @Synanto_TC_01
  Scenario: TC_01 Les elements de navbar(ACCUEIL, À PROPOS, EXPERTISES, REJOIGNE-NOUS, CONTACT) doivent être visibles et fonctionnels

    Then L'utilisateur vérifie que les champs concernés sont visibles fonctionnels
      | Accueil        |
      | À propos       |
      | Expertises     |
      | Rejoignez-nous |
      | Actualités     |
      | Contact        |

  @Synanto_TC_02
  Scenario Outline:TC_02 TEST ROBUSTESSE(negatif) Une Candidature spontanée ne peut pas être envoyée en laissant les champs obligatoires vides.
    When l'utilisateur clique sur le lien de Candidature spontanée
    And  L'utilisateur complète le formulaire "<Nom et prénom>","<E-mail>","<Téléphone>", "<Message>"
    And l'utilisateur télécharge son CV
    And l'utilisateur  clique sur le checkbox
    And l'utilisateur clique sur le bouton de envoyer
    Then utilisateur vérifie que le message davertissement rouge "Ce champ est obligatoire." saffiche


    Examples:
      | Nom et prénom | E-mail                    | Téléphone  | Message                                          |
      |               | gulfen3@yopmail.com       | 0658194363 | Ce serait formidable de travailler chez Synanto. |
      | Gul YALCIN    |                           | 0658194363 | Cette offre d'emploi me convient parfaitement.   |
      | Gul YALCIN    | gulyalcin2022@yopmail.com | 0658194363 |                                                  |

