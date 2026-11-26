package com.example.profildeveloppeurcompose.data

data class Skill(
    val name: String,
    val level: String
)

data class Project(
    val id: Int,
    val title: String,
    val description: String,
    val technologies: List<String>,
    val year: String
)

data class DeveloperProfile(
    val name: String,
    val role: String,
    val description: String,
    val location: String,
    val email: String,
    val availability: String,
    val isAvailable: Boolean,
    val skills: List<Skill>,
    val projects: List<Project>
)

fun sampleAndroidJuniorProfile(): DeveloperProfile {
    return DeveloperProfile(
        name = "Romain Berry",
        role = "Développeur Android junior",
        description = "Je cherche un stage pour progresser en Kotlin, Jetpack Compose et développement mobile Android. J'aime construire des interfaces claires et soignées.",
        location = "Paris, France",
        email = "romain.berry@example.com",
        availability = "Disponible pour un stage",
        isAvailable = true,
        skills = listOf(
            Skill(name = "Kotlin", level = "Intermédiaire"),
            Skill(name = "Jetpack Compose", level = "Intermédiaire"),
            Skill(name = "Material 3", level = "Débutant"),
            Skill(name = "Git", level = "Intermédiaire"),
            Skill(name = "Android Studio", level = "Intermédiaire")
        ),
        projects = listOf(
            Project(
                id = 1,
                title = "Product Explorer",
                description = "Catalogue de produits avec listes modernes, cartes réutilisables et thème clair / sombre.",
                technologies = listOf("Kotlin", "Compose", "Material 3"),
                year = "2026"
            ),
            Project(
                id = 2,
                title = "Profil développeur",
                description = "Première fiche de profil avec composables réutilisables, modifiers, callbacks et previews.",
                technologies = listOf("Kotlin", "Compose"),
                year = "2026"
            ),
            Project(
                id = 3,
                title = "Site portfolio",
                description = "Site personnel présentant mes projets et mon parcours de formation.",
                technologies = listOf("HTML", "CSS", "Git"),
                year = "2025"
            )
        )
    )
}

fun sampleFullStackProfile(): DeveloperProfile {
    return DeveloperProfile(
        name = "Camille Leroy",
        role = "Développeuse full-stack",
        description = "Développeuse polyvalente, je travaille sur des applications web et mobiles avec une attention particulière à la qualité du code.",
        location = "Lyon, France",
        email = "camille.leroy@example.com",
        availability = "Disponible en freelance",
        isAvailable = false,
        skills = listOf(
            Skill(name = "Kotlin", level = "Avancé"),
            Skill(name = "JavaScript", level = "Avancé"),
            Skill(name = "Spring Boot", level = "Intermédiaire"),
            Skill(name = "SQL", level = "Intermédiaire")
        ),
        projects = listOf(
            Project(
                id = 1,
                title = "Gestion de réservations",
                description = "Application web de réservation de salles avec tableau de bord administrateur.",
                technologies = listOf("Spring Boot", "SQL"),
                year = "2025"
            ),
            Project(
                id = 2,
                title = "App mobile de fidélité",
                description = "Application Android de carte de fidélité pour un réseau de boutiques.",
                technologies = listOf("Kotlin", "Compose"),
                year = "2024"
            )
        )
    )
}