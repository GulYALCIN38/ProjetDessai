@homepage_title

Feature:CheckTitles

  Background:
    Given  L'utilisateur visite le site de Thermo Fisher Scientific

  Scenario:TC_01 L'utilisateur doit pouvoir voir les elements de navbar(Hamburger bouton,
  logo de l'entreprise, dropdown de Rechercher, textbox de rechercher,
  Statut des commandes,Commande rapide, Se connecter ,panier ) sur la page d'accueil

    Then Vérifier que les éléments de navbar sont visibles

  Scenario:TC_02 L'utilisateur doit pouvoir cliquer sur  les elements de navbar

    Then Vérifier que les éléments de navbar sont cliquable


  Scenario:TC_03 L'utilisateur doit voir certains titres lorsqu'il clique sur le hamburger bouton,
  les titres doivent être fonctionnels et cliquables.

   When l'utilisateur clique sur le hamburger bouton
    Then vérifier que les éléments de hamburger bouton sont visibles
    Then  Vérifier que la couleur du titre1 est noire
    When l'utilisateur scroll le titre 1
    Then Vérifier que la couleur du titre1 est bleu
    When l'utilisateur clique sur le titre1
    Then  vérifier que ce titre1 "Anticorps" est visible


    Then  Vérifier que la couleur du titre2 est noire
    When l'utilisateur scroll le titre 2
    Then Vérifier que la couleur du titre2 est bleu
    When l'utilisateur clique sur le titre2
    Then  vérifier que ce titre2 "Bioprocédés" est visible

    Then  Vérifier que la couleur du titre3 est noire
    When l'utilisateur scroll le titre 3
    Then Vérifier que la couleur du titre3 est bleu
    When l'utilisateur clique sur le titre3
    Then  vérifier que ce titre3 "Services aux organisations de développement et de fabrication sous contrat (CDMO) et pour les essais cliniques" est visible

    Then  Vérifier que la couleur du titre4 est noire
    When l'utilisateur scroll le titre 4
    Then Vérifier que la couleur du titre4 est bleu
    When l'utilisateur clique sur le titre4
    Then  vérifier que ce titre4 "S’inscrire et créer un compte" est visible

    Then  Vérifier que la couleur du titre5 est noire
    When l'utilisateur scroll le titre 5
    Then Vérifier que la couleur du titre5 est bleu
    When l'utilisateur clique sur le titre5
    Then  vérifier que ce titre5 "Reaction PCR en temps réel TaqMan" est visible
    And l'utilisateur ferme la page








