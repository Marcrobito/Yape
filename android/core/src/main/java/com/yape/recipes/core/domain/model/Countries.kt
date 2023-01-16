package com.yape.recipes.core.domain.model

object Countries {

    fun getCoordinates(origin: String): Pair<Double, Double> = when (origin.lowercase()) {
        "french" -> Pair(46.2276, 2.2137)
        "indian" -> Pair(20.5937, 78.9629)
        "chinese" -> Pair(35.8617, 104.1954)
        "japanese" -> Pair(36.2048, 138.2529)
        "moroccan" -> Pair(31.7917, 7.0926)
        "jamaican" -> Pair(18.1096, -77.2975)
        "american" -> Pair(37.0902, -95.7129)
        "british" -> Pair(52.3555, -1.1743)
        "italian" -> Pair(41.8719, 12.5674)
        "greek" -> Pair(39.0742, 21.8243)
        "portuguese" -> Pair(39.3999, -8.2245)
        "mexican" -> Pair(23.6345, -102.5528)
        "croatian" -> Pair(45.1000, 15.2000)
        "irish" -> Pair(53.1424, -7.6921)
        "malaysian" -> Pair(4.2105, 101.9758)
        "russian" -> Pair(61.5240, 105.3188)
        "thai" -> Pair(15.8700, 100.9925)
        "vietnamese" -> Pair(14.0583, 108.2772)
        "tunisian" -> Pair(33.8869, 9.5375)
        "polish" -> Pair(51.9194, 19.1451)
        else -> Pair(0.0, 0.0)
    }

}