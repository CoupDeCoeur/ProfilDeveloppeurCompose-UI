package com.example.profildeveloppeurcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeurcompose.data.DeveloperProfile
import com.example.profildeveloppeurcompose.data.Project
import com.example.profildeveloppeurcompose.data.Skill
import com.example.profildeveloppeurcompose.data.sampleAndroidJuniorProfile
import com.example.profildeveloppeurcompose.ui.theme.ProfilDeveloppeurComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilDeveloppeurComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        profile = sampleAndroidJuniorProfile(),
                        onContactClick = {
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Composable
fun ProfileScreen(
    profile: DeveloperProfile,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ProfileHeader(
                name = profile.name,
                role = profile.role,
                location = profile.location
            )
        }
        item {
            AboutSection(description = profile.description)
        }
        item {
            SectionTitle(text = "Compétences")
        }
        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(profile.skills) { skill ->
                    SkillCard(skill = skill)
                }
            }
        }
        item {
            SectionTitle(text = "Projets")
        }
        items(
            items = profile.projects,
            key = { project -> project.id }
        ) { project ->
            ProjectCard(project = project)
        }
    }
}


@Composable
fun SectionTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
    )
}

@Composable
fun ProfileHeader(
    name: String,
    role: String,
    location: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.extraLarge,
        color = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileAvatar()
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = name, style = MaterialTheme.typography.headlineSmall)
            Text(text = role, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = location, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun ProfileAvatar(modifier: Modifier = Modifier) {
    Box(modifier = modifier.size(112.dp)) {
        Image(
            imageVector = Icons.Filled.Person,
            contentDescription = "Avatar du développeur",
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .padding(20.dp)
        )
        Surface(
            modifier = Modifier.align(Alignment.BottomEnd),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onTertiary,
            border = BorderStroke(3.dp, MaterialTheme.colorScheme.primaryContainer)
        ) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Disponible",
                modifier = Modifier
                    .padding(6.dp)
                    .size(18.dp)
            )
        }
    }
}

@Composable
fun AboutSection(description: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "À propos", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun SkillCard(skill: Skill, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        )
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            Text(text = skill.name, style = MaterialTheme.typography.titleMedium)
            Text(
                text = skill.level,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun ProjectCard(project: Project, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = project.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = project.year,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = project.technologies.joinToString(" • "),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


@Preview(name = "Profil - Thème clair", showBackground = true, heightDp = 1400)
@Composable
fun ProfileScreenLightPreview() {
    ProfilDeveloppeurComposeTheme(darkTheme = false) {
        ProfileScreen(
            profile = sampleAndroidJuniorProfile(),
            onContactClick = {}
        )
    }
}

@Preview(name = "Profil - Thème sombre", showBackground = true, heightDp = 1400)
@Composable
fun ProfileScreenDarkPreview() {
    ProfilDeveloppeurComposeTheme(darkTheme = true) {
        ProfileScreen(
            profile = sampleAndroidJuniorProfile(),
            onContactClick = {}
        )
    }
}