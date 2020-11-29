package dani.kotlin.domain.entities

data class PlaceInfo(
    val id: String?,
    val name: String?,
    val x: Double?,
    val y: Double?,
    val scheduledArrival: Int?,
    val locationType:  Int?,
    val companyZoneId: Int?,
    val lat: Double?,
    val lon: Double?,

    val licensePlate: String?,
    val range: Int?,
    val batteryLevel: Int?,
    val helmets: Int?,
    val model: String?,
    val resourceImageId: String?,
    val realTimeData: Boolean?,
    val resourceType: String?,

    val station: Boolean?,
    val availableResources: Int?,
    val spacesAvailable: Int?,
    val allowDropoff: Boolean?,
    val bikesAvailable: Int?
)