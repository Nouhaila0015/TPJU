Feature: Protection et Récupération d'une Œuvre d'Art

  Scenario: Un super-héros protège une œuvre et la récupère après un vol
    Given un super-héros "Superman"
    And une œuvre "La Joconde" créée par "Léonard de Vinci" en "1503"
    When on assigne "Superman" à la protection de "La Joconde"
    Then l'œuvre "La Joconde" doit être protégée par "Superman"

    When l'œuvre "La Joconde" est volée
    Then le super-héros "Superman" est alerté

    When "Superman" récupère l'œuvre "La Joconde"
    Then la mission de récupération est marquée comme réussie
    And l'œuvre "La Joconde" est à nouveau sécurisée

    Then le musée "Louvre" reçoit une notification
    And l’alerte indique que "Superman" a récupéré "La Joconde"
