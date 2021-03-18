interface Module {
    val plugins: List<String>
    val kotlinPlugins: List<String>

    val implementations: List<String>
    val testImplementations: List<String>
    val androidTestImplementations: List<String>
}
