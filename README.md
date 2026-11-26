# Profil Développeur Compose – Version UI améliorée – BERRY Romain

## Description
Application Android en Jetpack Compose qui présente le profil d'un développeur Android junior en recherche de stage.
Cette version reprend la première fiche « Profil développeur » et la transforme en un écran de profil plus complet : avatar, présentation, compétences, projets, zone de contact et bouton d'action.

## Capture d'écran

Thème clair: (screenshots/profil-clair.png) / Thème sombre: (screenshots/profil-sombre.png) 

## Composants Compose utilisés
- Text : nom, rôle, descriptions, titres de section, informations des cartes.
- Button : action « Contacter » (callback "onContactClick").
- Icon : localisation, badge de disponibilité, champs de contact et bouton.
- Image : avatar placeholder (icône "Person" teintée avec les couleurs du thème, découpée en cercle).
- Card : "SkillCard", "ProjectCard" et la zone de contact.
- OutlinedTextField en lecture seule ("readOnly = true") : email, localisation et disponibilité, via le composable réutilisable "ReadOnlyInfoField".

## Layouts utilisés
- Column : structure verticale de l'en-tête, des cartes et de la zone de contact.
- Row : icône + localisation sur une même ligne, titre + année d'un projet.
- Box : "ProfileAvatar" superpose un badge « disponible » en bas à droite de l'avatar.
- Spacer : espacements entre les éléments.
- Surface : en-tête du profil ("primaryContainer"), zone « À propos » ("secondaryContainer") et badge.

## Listes : LazyColumn et LazyRow
- LazyColumn ("ProfileScreen") : tout l'écran est une seule liste verticale (en-tête, À propos, titres, contact, bouton) et la liste des projets
  Chaque projet est affiché par le composable réutilisable "ProjectCard".
- LazyRow : les compétences défilent horizontalement, chacune affichée par le composable réutilisable "SkillCard" (nom + niveau).

## Choix du thème (Material Design 3)
- ColorScheme : une palette indigo pour l'identité principale, un gris en "secondary" pour les zones d'information
  et turquoise pour le badge de disponibilité. Deux palettes sont définies ("LightColorScheme" et "DarkColorScheme")
  et choisies automatiquement avec "isSystemInDarkTheme()".
- Typography ("ProfileTypography") : "headlineSmall" en gras pour le nom, "titleLarge" pour les titres de section, "titleMedium" pour les titres de carte, "bodyMedium" pour les textes.
- Shapes ("ProfileShapes") : arrondis de 8 / 12 / 20 / 28 dp, utilisés via "MaterialTheme.shapes".

## Previews
- "ProfileScreenLightPreview" : écran complet en thème clair.
- "ProfileScreenDarkPreview" : écran complet en thème sombre.

## Quelles notions du chapitre Compose UI avez-vous réutilisées dans cette application ?
J'ai réutilisé les composants fondamentaux (Text, Button, Icon, Image, Card, OutlinedTextField en lecture seule), les layouts
(Column, Row, Box pour l'avatar avec badge, Spacer, Surface) et les listes modernes : une "LazyColumn" pour l'écran et les projets,
une "LazyRow" pour les compétences, avec des cartes réutilisables ("ProjectCard", "SkillCard").
J'ai appliqué Material Design 3 avec un thème personnalisé (ColorScheme, Typography, Shapes) en version claire et sombre.
J'ai gardé les bonnes pratiques du premier devoir : composables courts avec paramètres, "modifier: Modifier = Modifier", callbacks et previews.