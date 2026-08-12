package io.github.degipe.youtubewhitelist.core.data.repository

import android.content.Context
import io.github.degipe.youtubewhitelist.core.data.model.AuthState
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    val authState: StateFlow<AuthState>
    suspend fun signIn(activityContext: Context)

    /**
     * Crée un compte parent purement local, sans passer par Google.
     * Le jeton OAuth n'est utilisé nulle part dans l'app : tous les appels
     * à l'API YouTube passent par la clé API (ApiKeyInterceptor).
     */
    suspend fun signInLocally()

    suspend fun signOut()
    suspend fun checkAuthState()
}
