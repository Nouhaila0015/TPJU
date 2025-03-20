Feature: US_001 Gestion des Toiles de Peinture Célèbre

  En tant que collectionneur d’art,
  Je veux ajouter une toile de peinture célèbre à ma collection
  Afin de mieux organiser et consulter mes œuvres d’art.

  Scenario Outline: Ajout d’une toile à une collection
    Given une toile "<nom>" de "<artiste>" créée en <anneeCreation>
    When l’utilisateur l’ajoute à la collection "<nomCollection>"
    Then la toile doit être associée à la collection

    Examples:
      | nom              | artiste            | anneeCreation | nomCollection |
      | La Joconde      | Léonard de Vinci   | 1503         | Louvre        |
      | Les Tournesols  | Vincent Van Gogh   | 1888         | MoMA          |

  Scenario Outline: Vérification des détails d’une toile
    Given une toile "<nom>" de "<artiste>" créée en <anneeCreation>
    When l’utilisateur consulte les détails
    Then le système affiche "Nom: <nom>, Artiste: <artiste>, Année: <anneeCreation>"

    Examples:
      | nom             | artiste           | anneeCreation |
      | Guernica       | Pablo Picasso     | 1937         |
      | Le Cri        | Edvard Munch      | 1893         |