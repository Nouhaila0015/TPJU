Feature: Ajout d’un super-héros à une équipe

  En tant que gestionnaire d’équipe
  Je veux ajouter un super-héros à une équipe
  Afin de constituer une équipe prête à combattre les menaces.

  Scenario: Ajouter un super-héros avec succès
    Given une équipe "Justice League" existe
    When j'ajoute "Superman" à l'équipe
    Then la confirmation "Superman a été ajouté à l'équipe Justice League !" doit s'afficher
    And la liste des super-héros de l'équipe doit contenir "Superman"

  Scenario: Empêcher l'ajout d'un super-héros en double
    Given une équipe "Justice League" avec le super-héros "Superman"
    When j'ajoute "Superman" à l'équipe
    Then un message d'erreur "Erreur : Superman est déjà dans l'équipe Justice League !" doit s'afficher
    And la liste des super-héros de l'équipe doit contenir "Superman" une seule fois
