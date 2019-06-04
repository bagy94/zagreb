@file:JvmName("DummyGenerator")
package hr.factory.base_module.utils

import android.content.Context
import hr.factory.base_module.R
import hr.factory.base_module.constants.*
import hr.factory.base_module.models.basic_information_raw.BasicInformationItemRaw
import hr.factory.base_module.models.basic_information_raw.BasicInformationRaw
import hr.factory.base_module.models.basic_information_raw.ContactRaw
import hr.factory.base_module.models.custom_lat_long.CustomLatLong
import hr.factory.base_module.models.location_raw_item.GalleryRaw
import hr.factory.base_module.models.location_raw_item.LocationRawItem
import hr.factory.base_module.models.location_raw_item.NowAndThenGalleryRaw
import hr.factory.base_module.models.location_raw_item.StringLocale
import io.realm.RealmList

/**
 * Created by domagoj on 26/10/17.
 */
fun createDummyLocationListCroatian(): MutableList<LocationRawItem> {
    val locationList: ArrayList<LocationRawItem> = ArrayList()
    locationList.add(LocationRawItem(0, StringLocale("Trg kralja Tomislava"),
            StringLocale("King Tomislav Square"),
            StringLocale("Prvi vlak stigao je u Zagreb 1862. godine kada " +
                    "grad ima 40 000 stanovnika. Historicističku " +
                    "zgradu Glavnog kolodvora projektirao je " +
                    "mađarski stručnjak za kolodvore Ferenc " +
                    "Pfaff. Sagrađena je 1892. godine i zatvara niz " +
                    "trgova na istočnom kraku zelene Lenucijeve " +
                    "potkove. Putnici i gosti Zagreba izlaskom iz " +
                    "kolodvora susreću se s jednom od najljepših " +
                    "vizura Zagreba – sa spomenikom kralju " +
                    "Tomislavu, Umjetničkim paviljonom, " +
                    "zvonicima katedrale i zelenim obroncima " +
                    "Medvednice. Spomenik kralju Tomislavu, " +
                    "prvom hrvatskom kralju izradio je kipar " +
                    "Robert Frangeš Mihanović 1938. godine." +
                    "Umjetnički paviljon sagrađen je povodom " +
                    "Milenijske izložbe u Budimpešti 1896. " +
                    "godine."),
            StringLocale("The railway" +
                    " arrived in Zagreb in 1862, connecting the 40,000-strong " +
                    "city to the economic and cultural centres of Vienna and Budapest." +
                    " Built in 1892, the station building was designed by Hungarian architect " +
                    "Ferenc Pfaff, something of a specialist when it came to railway stations." +
                    " Incorporating a mixture of Renaissance and Neo-classical elements, " +
                    "it is a fine addition to the parade of buildings that lies along the" +
                    " route of Lenuci’s Horseshoe. Travellers coming out of the railway " +
                    "station are confronted with one of the most beautiful views in Zagreb, " +
                    "which takes in the statue of King Tomislav, the Art Pavilion, " +
                    "the cathedral’s spires and the green slopes of Mount Medvednica in the distance."), "Trg kralja Tomislava 1",
            45.8053408, 15.978716200000, R.drawable.location_1, createImageUrl(PLACE_TOMISLAV, NOW_THEN, EMPTY_FOLDER, 1),
            createImageUrl(PLACE_TOMISLAV, NOW_THEN, EMPTY_FOLDER, 2), R.drawable.img_tomislav_map,
            createNowAndThenGallery(PLACE_TOMISLAV, SENDING), createGallery(PLACE_TOMISLAV, GALLERY)))
    locationList.add(LocationRawItem(1, StringLocale("Trg Nikole Šubića Zrinskoga"),
            StringLocale("Nikola Šubić Zrinski Square"),
            StringLocale("Trg je nazvan po Nikoli Šubiću Zrinskom " +
                    "(1508. – 1566.), hrvatskom banu koji je " +
                    "poginuo u junačkoj obrani mađarskog Sigeta " +
                    "od Turaka. U gradu zelenih trgova Zrinjevac " +
                    "je najpoznatiji. Teško je zamisliti da je do " +
                    "kraja 19. stoljeća na ovom mjestu bio pašnjak " +
                    "i stočno sajmište. Ono se preobražava u " +
                    "otmjenu promenadu s platanama uvezenim " +
                    "iz Trsta, glazbenim paviljonom, fontanama i " +
                    "bistama uglednika. Zrinjevac je prvi u nizu od " +
                    "osam trgova nastalih u urbanističkom " +
                    "planiranju inženjera Milana Lenucija. Po " +
                    "njemu se ovaj pandan bečkom ringu naziva " +
                    "Lenucijeva potkova. Tu započinje šetnja po " +
                    "Donjem gradu, galeriji građanske kulture 19. " +
                    "i 20. stoljeća."),
            StringLocale("Zrinjevac is arguably the" +
                    " best loved green square in Zagreb. " +
                    "The square gets its name from Nikola " +
                    "Šubić Zrinski (1508 – 1566), the Croatian " +
                    "Ban who died during the heroic defence of Szigetvar," +
                    " a Hungarian fortress besieged by the Ottoman Turks. " +
                    "It’s hard to imagine that this neat quadrangle of " +
                    "flowerbeds was until the late 19th century a meadow " +
                    "where cattle markets took place. Zrinjevac is the " +
                    "northernmost square of “Lenuci’s Horseshoe”, a " +
                    "line of eight green spaces laid out by municipal" +
                    " engineer Milan Lenuci in the 19th century." +
                    " An outdoor gallery of 19th- and 20th-century " +
                    "urban culture is a convenient starting point " +
                    "for a walking tour of the Lower Town."), "Trg Nikole Šubića Zrinskoga 1",
            45.8104869, 15.978938999999, R.drawable.location_9, createImageUrl(PLACE_ZRINJEVAC, NOW_THEN, EMPTY_FOLDER, 1),
            createImageUrl(PLACE_ZRINJEVAC, NOW_THEN, EMPTY_FOLDER, 2), R.drawable.img_zrisnki_map,
            createNowAndThenGallery(PLACE_ZRINJEVAC, SENDING), createGallery(PLACE_ZRINJEVAC, GALLERY)))
    locationList.add(LocationRawItem(2, StringLocale("Trg bana Josipa Jelačića"),
            StringLocale("Ban Jelačić Square"),
            StringLocale("Središnje mjesto grada Zagreba jest Trg bana " +
                    "Josipa Jelačića. Trg je nastao u podnožju " +
                    "dvaju naselja, Kaptola i Gradeca, uz izvor " +
                    "Manduševac. Gradske vlasti su 1641. godine " +
                    "odredile da će se tu održavati sajmovi. " +
                    "Današnje zgrade su nastajale od početka 19. " +
                    "stoljeća. Na njihovim fasadama su vidljivi " +
                    "različiti graditeljski stilovi od neostilova 19. " +
                    "stoljeća, bidermajera i secesije do moderne i " +
                    "postmoderne. Spomenik banu Josipu Jelačiću " +
                    "rad je austrijskog kipara Antona Fernkorna."),
            StringLocale("Central focus of modern Zagreb is Ban Jelačić Square (Trg bana Jelačića)." +
                    " Situated just below the hillside settlements of Kaptol and Gradec, " +
                    "it has served as the city’s commercial heart ever since 1641, when" +
                    " it was designated as a place where fairs could be held. Most" +
                    " of the buildings around the square date from the 19th century," +
                    " and display a variety of architectural styles, from Biedermaier to Art Nouveau and Post-modernism." +
                    "The statue of Ban Josip Jelačić is the work of the Austrian sculptor Anton Fernkorn."), "Trg bana Josipa Jelačića 1",
            45.8128451, 15.977494900000, R.drawable.location_2, createImageUrl(PLACE_JELACIC, NOW_THEN, EMPTY_FOLDER, 1),
            createImageUrl(PLACE_JELACIC, NOW_THEN, EMPTY_FOLDER, 2), R.drawable.img_ban_map,
            createNowAndThenGallery(PLACE_JELACIC, SENDING), createGallery(PLACE_JELACIC, GALLERY)))
    locationList.add(LocationRawItem(3, StringLocale("Kaptol"),
            StringLocale("Kaptol"),
            StringLocale("Katedrala Uznesenja Blažene Djevice Marije " +
                    "jedan je od simbola grada Zagreba. Ona je " +
                    "izniman primjer promjene kroz graditeljske " +
                    "stilove jer su na tom kompleksu zastupljeni " +
                    "gotovo svi stilovi. Veliki potres 1880. godine " +
                    "nanio je velike štete katedrali i cijelom gradu. " +
                    "Tada započinje obnova katedrale u " +
                    "neogotičkom stilu u skladu s europskim " +
                    "trendovima. Prema nacrtima austrijskog " +
                    "graditelja Friedricha von Schmidta izgradnju " +
                    "je vodio Herman Bollé. Katedrala dobiva svoj " +
                    "današnji oblik s dva vitka tornja vidljiva iz " +
                    "cijeloga grada."),
            StringLocale("Characterized by its soaring twin towers, " +
                    "the Cathedral of the Assumption of the " +
                    "Blessed Virgin Mary is one of Zagreb’s " +
                    "defining symbols. Although it is a" +
                    " largely Neo-Gothic structure dating " +
                    "from the late 19th century, its origins" +
                    " are much older. A huge earthquake in " +
                    "1880 did enormous damage to the cathedral," +
                    " and it was reconstructed along Neo-Gothic " +
                    "lines. Local architect Herman Bolle was" +
                    " in charge of the project, although the " +
                    "blueprints were provided by Austrian" +
                    " designer Friedrich von Schmidt. " +
                    "Thus the cathedral took on its present-day " +
                    "shape with its slender 105-metre-high" +
                    " towers dominating the Zagreb skyline."), "Kaptol ulica 1",
            45.814367, 15.978369400000, R.drawable.location_10, createImageUrl(PLACE_KAPTOL, NOW_THEN, EMPTY_FOLDER, 1),
            createImageUrl(PLACE_KAPTOL, NOW_THEN, EMPTY_FOLDER, 2), R.drawable.img_kaptop_map,
            createNowAndThenGallery(PLACE_KAPTOL, SENDING), createGallery(PLACE_KAPTOL, GALLERY)))
    locationList.add(LocationRawItem(4, StringLocale("Kamenita vrata"),
            StringLocale("The Stone Gate"),
            StringLocale("Kamenita vrata spominju se u srednjem " +
                    "vijeku, a današnji oblik dobila su " +
                    "pregradnjom u 18. stoljeću. U prolazu se " +
                    "smješta kapela Majke Božje oko slike koja je " +
                    "čudom spašena u razornom požaru 1731. " +
                    "godine. Od tada su Kamenita vrata mjesto " +
                    "hodočašća sa zahvalama Majci Božjoj iz svih " +
                    "krajeva svijeta. Lanci postavljeni na današnje " +
                    "mjesto 1878. godine potječu s čuvenoga " +
                    "britanskog ratnog broda HMS Victory. Njime " +
                    "je 1805. godine zapovijedao admiral Nelson " +
                    "u bitci kod Trafalgara. U Kamenitoj ulici " +
                    "nalazi se najstarija ljekarna u Zagrebu, " +
                    "otvorena 1355. godine."),
            StringLocale("Built in the Middle Ages, Stone " +
                    "Gate (Kamenita vrata in Croatian) assumed " +
                    "its final form after being rebuilt in the " +
                    "18th century. Under the arch of the gateway" +
                    " is a chapel dedicated to the Virgin Mary. " +
                    "It holds a painting of the Virgin that" +
                    " was miraculously saved from a devastating " +
                    "fire in the year 1731, and the chapel has" +
                    " been a place of pilgrimage ever since." +
                    " Placed at their current location in 1878, " +
                    "the chains belonged originally to the famous " +
                    "British warship HMS Victory. Kamenita ulica " +
                    "(“Stone Street”) is the site of the oldest" +
                    " pharmacy in Zagreb, founded in the year 1355."), "Kamenita vrata 1",
            45.8157298, 15.975236900000, R.drawable.location_3, createImageUrl(PLACE_KAMENITA, NOW_THEN, EMPTY_FOLDER, 1),
            createImageUrl(PLACE_KAMENITA, NOW_THEN, EMPTY_FOLDER, 2), R.drawable.img_kamenita_map,
            createNowAndThenGallery(PLACE_KAMENITA, SENDING), createGallery(PLACE_KAMENITA, GALLERY)))
    locationList.add(LocationRawItem(5, StringLocale("Trg sv.Marka"),
            StringLocale("St Mark’s Square"),
            StringLocale("Markov trg središte je Gornjega grada i glavni " +
                    "trg nekadašnjega Gradeca. U središtu trga je " +
                    "župna crkva Sv. Marka sagrađena sredinom " +
                    "13. stoljeća. Banski dvori na adresi Markov " +
                    "trg 1 sjedište su hrvatske vlade i ured su " +
                    "premijera. Palača je sagrađena početkom 19. " +
                    "stoljeća i dom je hrvatskih banova od 1808. " +
                    "do 1918. godine. Tu je živio i umro " +
                    "legendarni ban Josip Jelačić. Na ovoj lokaciji " +
                    "zasjeda Sabor od prve sjednice održane " +
                    "1737. godine. Današnji izgled zgrada ima od " +
                    "početka 20. stoljeća. Tu su donesene odluke " +
                    "o odcjepljenju od Austro-Ugarske 1918. " +
                    "godine i izlasku iz Jugoslavije 1991. godine."),
            StringLocale("St Mark’s Square (Trg svetog Marka) " +
                    "constitutes the heart of the Upper Town, having " +
                    "formerly served as the main market square of" +
                    " the settlement of Gradec. The Banski dvori " +
                    "or “Governor’s Palace” at St Mark’s Square " +
                    "1 is the seat of the Croatian Government " +
                    "and also houses the office of the Prime Minister." +
                    " The palace was built in the beginning of" +
                    " the 19th century and was home to the" +
                    " Croatian bans (governors) from 1808 to 1918. " +
                    "The legendary Ban Josip Jelačić lived and died " +
                    "here. The Croatian Sabor or Parliament has" +
                    " held its sessions at this location ever since 1737. " +
                    "It was here that members voted to sever" +
                    " political ties from the Austro-Hungarian" +
                    " Empire in 1918 and from Yugoslavia in 1991."), "Trg sv. Marka 1",
            45.8163381, 15.973376000000, R.drawable.location_4, createImageUrl(PLACE_SVETI_MARKO, NOW_THEN, EMPTY_FOLDER, 1),
            createImageUrl(PLACE_SVETI_MARKO, NOW_THEN, EMPTY_FOLDER, 2), R.drawable.img_marko_map,
            createNowAndThenGallery(PLACE_SVETI_MARKO, SENDING), createGallery(PLACE_SVETI_MARKO, GALLERY)))
    locationList.add(LocationRawItem(6, StringLocale("Ilica"),
            StringLocale("Ilica"),
            StringLocale("Najpoznatija zagrebačka ulica jest Ilica. Dugo " +
                    "vremena je sa šest kilometara dužine bila " +
                    "najduža ulica u gradu, a danas je tek četvrta " +
                    "jer su ju pretekle nove avenije. Bez obzira na " +
                    "poredak, Ilica je zadržala bogat život i ulogu " +
                    "glavne gradske arterije s trgovinama, " +
                    "upravnim zgradama, kazalištima pa čak i " +
                    "prvom pivovarom. Jedna je od rijetkih ulica " +
                    "koja nije mijenjala naziv od 15. stoljeća. Zbog " +
                    "smjera istok—zapad, poznata je i po " +
                    "zasljepljujućem suncu kada se u " +
                    "popodnevnim satima krećete u smjeru " +
                    "zapada."),
            StringLocale("Of all the streets in Zagreb, " +
                    "Ilica is the one which the locals hold dearest." +
                    " Six kilometers in length, it was for a long " +
                    "time the longest street in the city, although " +
                    "some of the newer multi-lane avenues are now longer." +
                    " However Ilica remains the symbolic main artery of " +
                    "the city, with highstreet shops and government " +
                    "buildings lining its eastern end, theatres and " +
                    "markets (and even Zagreb’s first brewery) emerging " +
                    "as it moves west. It is also one of the rare streets" +
                    "that has kept the same name since its origins in the " +
                    "15th century. Because of its east-west direction it " +
                    "is famous for the bright sunlight that hits you " +
                    "as you walk westward in the late afternoon."), "Ilica 1",
            45.812552, 15.976097999999, R.drawable.location_5, createImageUrl(PLACE_ILICA, NOW_THEN, EMPTY_FOLDER, 1),
            createImageUrl(PLACE_ILICA, NOW_THEN, EMPTY_FOLDER, 2), R.drawable.img_ilica_map,
            createNowAndThenGallery(PLACE_ILICA, SENDING), createGallery(PLACE_ILICA, GALLERY)))
    locationList.add(LocationRawItem(7, StringLocale("Trg Petra Preradovića"),
            StringLocale("Petar Preradović Square"),
            StringLocale("Trg Petra Preradovića nazvan je imenom " +
                    "generala i pjesnika domoljubnih i ljubavnih " +
                    "tema (Petar Preradović 1818. - 1872.). " +
                    "Njegov spomenik je u sredini trga. Međutim " +
                    "službeni naziv trga se rijetko koristi jer ga svi " +
                    "zovu Cvjetni trg. Od 14. stoljeća se tu " +
                    "održavaju sajmovi, a popularno ime dolazi od " +
                    "štandova s cvijećem. Na sjevernoj strani trga " +
                    "pravoslavna je crkva Svetog Preobraženja " +
                    "sagrađena koncem 19. stoljeća na mjestu " +
                    "rimokatoličke crkve Svete Margarete."),
            StringLocale("Petar Preradović Square was named " +
                    "after Petar Preradović (1818 – 1872), an army " +
                    "general who also wrote patriotic verse and " +
                    "love poetry. His statue stands in the middle " +
                    "of the square and is a popular meeting point. " +
                    "The square is colloquially known as “Flower " +
                    "Square” (Cvjetni trg), after the flower stalls " +
                    "which have been a feature of the place ever " +
                    "since the 14th century when fairs were held" +
                    " here. On the northern side of the square is " +
                    "the Orthodox Church of the Holy Transfiguration, " +
                    "built at the end of the 19th century on the " +
                    "former site of the Roman Catholic Church of St Margaret. "), "Trg Petra Preradovića 1",
            45.8121376000, 15.973805599999, R.drawable.location_6, createImageUrl(PLACE_PRERADOVIC, NOW_THEN, EMPTY_FOLDER, 1),
            createImageUrl(PLACE_PRERADOVIC, NOW_THEN, EMPTY_FOLDER, 2), R.drawable.img_preradovic_map,
            createNowAndThenGallery(PLACE_PRERADOVIC, SENDING), createGallery(PLACE_PRERADOVIC, GALLERY)))
    locationList.add(LocationRawItem(8, StringLocale("Trg Republike Hrvatske"),
            StringLocale("Republic of Croatia Square"),
            StringLocale("Hrvatsko narodno kazalište nalazi se na Trgu " +
                    "Republike Hrvatske. Kao svojevrsno središte " +
                    "kulture taj trg je zadnji u nizu od osam " +
                    "zelenih trgova koji čine okosnicu planiranja " +
                    "grada u 19. stoljeću. Arhitektura " +
                    "historicističkog stila koji interpretira bogate " +
                    "oblike baroka 17. stoljeća smatrala se " +
                    "prikladnom za kazališta. Kazalište je svečano " +
                    "otvoreno 1895. godine. Od tada ta institucija " +
                    "bogatim repertoarom od svjetskih klasika do " +
                    "nacionalne tradicije i suvremenog " +
                    "stvaralaštva obogaćuje kulturni život " +
                    "Zagreba. " +
                    "Fontana s nazivom Zdenac života djelo je " +
                    "kipara Ivana Meštrovića nastalo početkom " +
                    "20. stoljeća kada je i postavljeno ispred " +
                    "Hrvatskoga narodnog kazališta."),
            StringLocale("The Croatian National Theatre is" +
                    " located on the Republic of Croatia Square. " +
                    "This square is the last in the arc of eight " +
                    "green squares that formed Lenuci’s Horseshoe," +
                    " the central component of 19th-century Zagreb’s " +
                    "urban plan. Well-known Viennese architects Ferdinand" +
                    " Fellner and Herman Helmer, who designed forty" +
                    " other European theatres, were responsible for " +
                    "the plans for the building, employing a rich " +
                    "Neo-Baroque style that was at the time thought " +
                    "most suitable for theatres. Officially opened in " +
                    "1895, the building brings the national opera," +
                    " ballet and drama companies together under a " +
                    "single roof. Placed in front of the National " +
                    "Theatre in 1912, the Well of Life is one of " +
                    "Croatian sculptor Ivan Meštrović’s most popular works."), "Trg Republike Hrvatske 1",
            45.8098063, 15.969837600000005, R.drawable.location_7, createImageUrl(PLACE_TRG_REPUBLIKE, NOW_THEN, EMPTY_FOLDER, 1),
            createImageUrl(PLACE_TRG_REPUBLIKE, NOW_THEN, EMPTY_FOLDER, 2), R.drawable.img_republika_map,
            createNowAndThenGallery(PLACE_TRG_REPUBLIKE, SENDING), createGallery(PLACE_TRG_REPUBLIKE, GALLERY)))
    locationList.add(LocationRawItem(9, StringLocale("Trg Marka Marulića"),
            StringLocale("Marko Marulić Square"),
            StringLocale("Marulićevim trgom dominira nekadašnja " +
                    "zgrada Nacionalne i sveučilišne knjižnice koja " +
                    "se danas koristi za potrebe Hrvatskog " +
                    "državnog arhiva. Uvjerljivo najljepše zdanje " +
                    "secesijske arhitekture u Hrvatskoj dovršeno " +
                    "je 1913. godine prema projektu arhitekta " +
                    "Rudolfa Lubynskoga. Četiri sove koje nose " +
                    "globuse smještene uz vanjski dio kupole nad " +
                    "glavnom čitaonicom najavljuju namjenu " +
                    "zgrade, isto kao i alegorije znanosti i " +
                    "knjižarstva na pročeljima. U ulici nazvanoj po " +
                    "autoru teksta hrvatske himne Lijepa naša " +
                    "domovino, Antunu Mihanoviću, nalazi se " +
                    "Botanički vrt. Smješten uz željezničku prugu " +
                    "dio je niza zelenih perivoja Lenucijeve " +
                    "potkove."),
            StringLocale("Marulić Square is dominated by" +
                    " the former National and University Library, " +
                    "today home to the Croatian State Archives. " +
                    "Designed by architect Rudolf Lubynski in 1913," +
                    " the building is by far the most beautiful example " +
                    "of Croatian Art Nouveau. Every detail, from the " +
                    "decorative elements on the facade to the reading " +
                    "lamps on the desks, was meticulously designed by " +
                    "the leading artists of the day. The building is " +
                    "rich in symbolism, with rooftop groups of " +
                    "globebearing owls pointing to the library’s" +
                    " educational purpose. Similarly, allegories " +
                    "of science and the book trade adorn the facade. " +
                    "Running parallel to the railway tracks, the " +
                    "Botanical Gardens form the southern part of " +
                    "the green belt known as Lenuci’s Horseshoe."), "Trg Marka Marulića 1",
            45.806414, 15.970995000000, R.drawable.location_8, createImageUrl(PLACE_MARULIC, NOW_THEN, EMPTY_FOLDER, 1),
            createImageUrl(PLACE_MARULIC, NOW_THEN, EMPTY_FOLDER, 2), R.drawable.img_marulic_map,
            createNowAndThenGallery(PLACE_MARULIC, SENDING), createGallery(PLACE_MARULIC, GALLERY)))
    return locationList
}
/*
fun createHistoryWalk(): HistoryWalk {
    val historyWalk = HistoryWalk(getDummyHitoryWalkPresentMap(), getDummyHitoryWalkHistoryMap())
    return historyWalk
}*/

fun getDummyHitoryWalkPresentMap(): RealmList<CustomLatLong> {
    val list: RealmList<CustomLatLong> = RealmList<CustomLatLong>()
    list.add(CustomLatLong(0, 45.805273, 15.979111))
    list.add(CustomLatLong(1, 45.805295, 15.979432))
    list.add(CustomLatLong(2, 45.806364, 15.979368))
    list.add(CustomLatLong(3, 45.807605, 15.979282))
    list.add(CustomLatLong(4, 45.808577, 15.979207))
    list.add(CustomLatLong(5, 45.809452, 15.979143))
    list.add(CustomLatLong(6, 45.810207, 15.979004))
    list.add(CustomLatLong(7, 45.810506, 15.978918))
    list.add(CustomLatLong(8, 45.811471, 15.978725))
    list.add(CustomLatLong(9, 45.811471, 15.978071))
    list.add(CustomLatLong(10, 45.811426, 15.977449))
    list.add(CustomLatLong(11, 45.811987, 15.977503))
    list.add(CustomLatLong(12, 45.812667, 15.977600))
    list.add(CustomLatLong(13, 45.812802, 15.977589))
    list.add(CustomLatLong(14, 45.812727, 15.977932))
    list.add(CustomLatLong(15, 45.812660, 15.978232))
    list.add(CustomLatLong(16, 45.813131, 15.978404))
    list.add(CustomLatLong(17, 45.813954, 15.978586))
    list.add(CustomLatLong(18, 45.814253, 15.978575))
    list.add(CustomLatLong(19, 45.814410, 15.978554))
    list.add(CustomLatLong(20, 45.814402, 15.978242))
    list.add(CustomLatLong(21, 45.814424, 15.978053))
    list.add(CustomLatLong(22, 45.814375, 15.977978))
    list.add(CustomLatLong(23, 45.814386, 15.977865))
    list.add(CustomLatLong(24, 45.814453, 15.977667))
    list.add(CustomLatLong(25, 45.814498, 15.977662))
    list.add(CustomLatLong(26, 45.814577, 15.977565))
    list.add(CustomLatLong(27, 45.814588, 15.977383))
    list.add(CustomLatLong(28, 45.814788, 15.977376))
    list.add(CustomLatLong(29, 45.814904, 15.976280))
    list.add(CustomLatLong(30, 45.814842, 15.976216))
    list.add(CustomLatLong(31, 45.814773, 15.976149))
    list.add(CustomLatLong(32, 45.814778, 15.975628))
    list.add(CustomLatLong(33, 45.816126, 15.975574))
    list.add(CustomLatLong(34, 45.816107, 15.975443))
    list.add(CustomLatLong(35, 45.816042, 15.975389))
    list.add(CustomLatLong(36, 45.815937, 15.975338))
    list.add(CustomLatLong(37, 45.815842, 15.975290))
    list.add(CustomLatLong(38, 45.815793, 15.975260))
    list.add(CustomLatLong(39, 45.815826, 15.974770))
    list.add(CustomLatLong(40, 45.815945, 15.973905))
    list.add(CustomLatLong(41, 45.815979, 15.973519))
    list.add(CustomLatLong(42, 45.816013, 15.973299))
    list.add(CustomLatLong(43, 45.816391, 15.973374))
    list.add(CustomLatLong(44, 45.816016, 15.973322))
    list.add(CustomLatLong(45, 45.815979, 15.973461))
    list.add(CustomLatLong(46, 45.815381, 15.973440))
    list.add(CustomLatLong(47, 45.814887, 15.973386))
    list.add(CustomLatLong(48, 45.814547, 15.973364))
    list.add(CustomLatLong(49, 45.814558, 15.973290))
    list.add(CustomLatLong(50, 45.814515, 15.973292))
    list.add(CustomLatLong(51, 45.814486, 15.973303))
    list.add(CustomLatLong(52, 45.814461, 15.973332))
    list.add(CustomLatLong(53, 45.814299, 15.973734))
    list.add(CustomLatLong(54, 45.814253, 15.973911))
    list.add(CustomLatLong(55, 45.814175, 15.974644))
    list.add(CustomLatLong(56, 45.814140, 15.974735))
    list.add(CustomLatLong(57, 45.813916, 15.975181))
    list.add(CustomLatLong(58, 45.813886, 15.975278))
    list.add(CustomLatLong(59, 45.813903, 15.975869))
    list.add(CustomLatLong(60, 45.813667, 15.976033))
    list.add(CustomLatLong(61, 45.813506, 15.976164))
    list.add(CustomLatLong(62, 45.813362, 15.976253))
    list.add(CustomLatLong(63, 45.813280, 15.976264))
    list.add(CustomLatLong(64, 45.813054, 15.976245))
    list.add(CustomLatLong(65, 45.813057, 15.975461))
    list.add(CustomLatLong(66, 45.813069, 15.974553))
    list.add(CustomLatLong(67, 45.812334, 15.974368))
    list.add(CustomLatLong(68, 45.812334, 15.973818))
    list.add(CustomLatLong(69, 45.811946, 15.973818))
    list.add(CustomLatLong(70, 45.811940, 15.974193))
    list.add(CustomLatLong(71, 45.811239, 15.974269))
    list.add(CustomLatLong(72, 45.811071, 15.973727))
    list.add(CustomLatLong(73, 45.810742, 15.972708))
    list.add(CustomLatLong(74, 45.810522, 15.972112))
    list.add(CustomLatLong(75, 45.810361, 15.971549))
    list.add(CustomLatLong(76, 45.810234, 15.971018))
    list.add(CustomLatLong(77, 45.810170, 15.970562))
    list.add(CustomLatLong(78, 45.810114, 15.970610))
    list.add(CustomLatLong(79, 45.809867, 15.970143))
    list.add(CustomLatLong(80, 45.809878, 15.970009))
    list.add(CustomLatLong(81, 45.809860, 15.969843))
    list.add(CustomLatLong(82, 45.809819, 15.969816))
    list.add(CustomLatLong(83, 45.809812, 15.969618))
    list.add(CustomLatLong(84, 45.809808, 15.969827))
    list.add(CustomLatLong(85, 45.809815, 15.970203))
    list.add(CustomLatLong(86, 45.809830, 15.970418))
    list.add(CustomLatLong(87, 45.808951, 15.970466))
    list.add(CustomLatLong(88, 45.808951, 15.970890))
    list.add(CustomLatLong(89, 45.807416, 15.970924))
    list.add(CustomLatLong(90, 45.807356, 15.970066))
    return list
}

fun getDummyHitoryWalkHistoryMap(): RealmList<CustomLatLong> {
    val list: RealmList<CustomLatLong> = RealmList<CustomLatLong>()
    list.add(CustomLatLong(0, 45.805273, 15.979111))
    list.add(CustomLatLong(1, 45.805924, 15.979103))
    list.add(CustomLatLong(2, 45.807230, 15.979077))
    list.add(CustomLatLong(3, 45.809252, 15.979049))
    list.add(CustomLatLong(4, 45.810332, 15.978863))
    list.add(CustomLatLong(5, 45.811333, 15.978530))
    list.add(CustomLatLong(6, 45.811319, 15.977475))
    list.add(CustomLatLong(7, 45.811987, 15.977503))
    list.add(CustomLatLong(8, 45.812667, 15.977600))
    list.add(CustomLatLong(9, 45.812802, 15.977589))
    list.add(CustomLatLong(10, 45.812727, 15.977932))
    list.add(CustomLatLong(11, 45.812660, 15.978232))
    list.add(CustomLatLong(12, 45.813131, 15.978404))
    list.add(CustomLatLong(13, 45.813954, 15.978586))
    list.add(CustomLatLong(14, 45.814253, 15.978575))
    list.add(CustomLatLong(15, 45.814410, 15.978554))
    list.add(CustomLatLong(16, 45.814402, 15.978242))
    list.add(CustomLatLong(17, 45.814424, 15.978053))
    list.add(CustomLatLong(18, 45.814375, 15.977978))
    list.add(CustomLatLong(19, 45.814386, 15.977865))
    list.add(CustomLatLong(20, 45.814453, 15.977667))
    list.add(CustomLatLong(21, 45.814498, 15.977662))
    list.add(CustomLatLong(22, 45.814577, 15.977565))
    list.add(CustomLatLong(23, 45.814588, 15.977383))
    list.add(CustomLatLong(24, 45.814788, 15.977376))
    list.add(CustomLatLong(25, 45.814904, 15.976280))
    list.add(CustomLatLong(26, 45.814842, 15.976216))
    list.add(CustomLatLong(27, 45.814773, 15.976149))
    list.add(CustomLatLong(28, 45.814778, 15.975628))
    list.add(CustomLatLong(29, 45.816126, 15.975574))
    list.add(CustomLatLong(30, 45.816107, 15.975443))
    list.add(CustomLatLong(31, 45.816042, 15.975389))
    list.add(CustomLatLong(32, 45.815937, 15.975338))
    list.add(CustomLatLong(33, 45.815842, 15.975290))
    list.add(CustomLatLong(34, 45.815793, 15.975260))
    list.add(CustomLatLong(35, 45.815828, 15.975285))
    list.add(CustomLatLong(36, 45.815886, 15.975061))
    list.add(CustomLatLong(37, 45.815879, 15.974875))
    list.add(CustomLatLong(38, 45.815989, 15.974545))
    list.add(CustomLatLong(39, 45.816178, 15.973770))
    list.add(CustomLatLong(40, 45.815150, 15.973633))
    list.add(CustomLatLong(41, 45.814642, 15.973628))
    list.add(CustomLatLong(42, 45.814476, 15.973994))
    list.add(CustomLatLong(43, 45.814387, 15.974572))
    list.add(CustomLatLong(44, 45.814167, 15.974767))
    list.add(CustomLatLong(45, 45.813960, 15.975331))
    list.add(CustomLatLong(46, 45.813929, 15.975978))
    list.add(CustomLatLong(47, 45.813360, 15.976264))
    list.add(CustomLatLong(48, 45.813054, 15.976245))
    list.add(CustomLatLong(49, 45.813057, 15.975461))
    list.add(CustomLatLong(50, 45.813069, 15.974553))
    list.add(CustomLatLong(51, 45.812334, 15.974368))
    list.add(CustomLatLong(52, 45.812334, 15.973818))
    list.add(CustomLatLong(53, 45.811920, 15.97391))
    list.add(CustomLatLong(54, 45.811916, 15.974275))
    list.add(CustomLatLong(55, 45.811283, 15.974297))
    list.add(CustomLatLong(56, 45.810591, 15.972177))
    list.add(CustomLatLong(57, 45.810213, 15.970981))
    list.add(CustomLatLong(58, 45.810191, 15.970914))
    list.add(CustomLatLong(59, 45.809886, 15.970828))
    list.add(CustomLatLong(60, 45.809843, 15.970622))
    list.add(CustomLatLong(61, 45.809812, 15.970567))
    list.add(CustomLatLong(62, 45.809341, 15.970616))
    list.add(CustomLatLong(63, 45.808964, 15.970625))
    list.add(CustomLatLong(64, 45.808951, 15.970890))
    list.add(CustomLatLong(65, 45.807416, 15.970924))
    list.add(CustomLatLong(66, 45.807356, 15.970066))
    return list
}

private fun createGallery(soruceName: String, folderName: String): RealmList<GalleryRaw> {
    val digitalUrlList = getDigitalGallery(soruceName)
    val list = RealmList<GalleryRaw>()
    for (i in 1..digitalUrlList.size) {
        val item = digitalUrlList[i - 1]
        list.add(GalleryRaw(createImageUrl(soruceName, folderName, i, FRONT), createImageUrl(soruceName, folderName, i, BACK), item))
    }
    return list
}

private fun createNowAndThenGallery(soruceName: String, folderName: String): RealmList<NowAndThenGalleryRaw> {
    val digitalUrlList = getDigitalGalleryBeforeAndAfetrLinks(soruceName)
    val list = RealmList<NowAndThenGalleryRaw>()
    for (i in 1..digitalUrlList.size) {
        val item = digitalUrlList[i - 1]
        list.add(NowAndThenGalleryRaw(createImageUrl(soruceName, folderName, i, FRONT), createImageUrl(soruceName, folderName, i, BACK), item))
    }
    return list
}

private fun createImageUrl(soruceName: String, folderName: String, i: Int, j: Int): String {
    if (i == 0) {
        return BASE_URL + SLASH + soruceName + SLASH + folderName + SLASH + j + JPG
    } else {
        return BASE_URL + SLASH + soruceName + SLASH + folderName + SLASH + i + SLASH + j + JPG
    }
}

fun getDigitalGallery(soruceName: String): List<String> {
    val stringList = ArrayList<String>()
    when (soruceName) {
        PLACE_TOMISLAV -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14777")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15053")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11122")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14779")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14773")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11123")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15052")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15008")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15010")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15013")
        }

        PLACE_ZRINJEVAC -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11143")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11633")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11144")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14976")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14989")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14987")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10886")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14986")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14979")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11754")
        }

        PLACE_JELACIC -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14925")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14924")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11021")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11022")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11023")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11027")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14906")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14913")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14914")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14915")
        }

        PLACE_KAPTOL -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15046")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15063")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10737")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15073")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15144")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14909")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15093")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15213")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15151")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15212")
        }

        PLACE_KAMENITA -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15251")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15256")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10456")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15249")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10467")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15255")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15257")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10190")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15250")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15253")
        }

        PLACE_SVETI_MARKO -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11545")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15130")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15139")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15133")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22223")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22225")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22227")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22228")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22234")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22230")
        }

        PLACE_ILICA -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21694")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21766")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21693")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21765")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21507")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21756")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21729")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21759")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21696")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21728")
        }

        PLACE_PRERADOVIC -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10863")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15006")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10865")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14997")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10550")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15001")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15003")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10548")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15004")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14999")
        }

        PLACE_TRG_REPUBLIKE -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14797")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10521")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14821")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14813")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14829")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14831")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14800")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14832")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14811")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14795")
        }

        PLACE_MARULIC -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14751")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14806")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14747")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14750")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14744")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14745")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14749")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10530")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10534")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11926")
        }
    }
    return stringList
}

private fun getDigitalGalleryBeforeAndAfetrLinks(soruceName: String): List<String> {
    val stringList = ArrayList<String>()
    when (soruceName) {
        PLACE_TOMISLAV -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15041")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15030")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14793")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14790")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14768")
        }

        PLACE_ZRINJEVAC -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11142")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11572")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14982")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11141")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11140")
        }

        PLACE_JELACIC -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22136")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14920")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14921")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14919")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14910")
        }

        PLACE_KAPTOL -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15032")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10667")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15077")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15214")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10833")
        }

        PLACE_KAMENITA -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10193")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22137")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15248")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15254")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15258")
        }

        PLACE_SVETI_MARKO -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21606")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11544")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15135")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11546")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11547")
        }

        PLACE_ILICA -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10472")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22221")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22128")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10475")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10473")
        }

        PLACE_PRERADOVIC -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=21629")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15002")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=15005")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10549")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10864")
        }

        PLACE_TRG_REPUBLIKE -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11250")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14834")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14816")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14814")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=11247")
        }

        PLACE_MARULIC -> {
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14748")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14752")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=14746")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=10531")
            stringList.add("http://digitalna.nsk.hr/?object=view&id=22232")
        }
    }
    return stringList
}

fun createDummy(context: Context): BasicInformationRaw {
    return BasicInformationRaw(PRIMARY_KEY_INT, createTeam(context), createInvestors(context), createDevelopment(context), createAbout(context))
}

private fun createTeam(context: Context): BasicInformationItemRaw {
    return BasicInformationItemRaw(context.getString(R.string.team), createTeamContactListHr(), createTeamContactListEn())
}

private fun createInvestors(context: Context): BasicInformationItemRaw {
    return BasicInformationItemRaw(context.getString(R.string.investors), StringLocale(EMPTY_STRING), StringLocale(EMPTY_STRING), createInvestorsContactList(), createInvestorsContactList())
}

private fun createDevelopment(context: Context): BasicInformationItemRaw {
    return BasicInformationItemRaw(context.getString(R.string.design_and_development), StringLocale(context.getString(R.string.development_en)), StringLocale(context.getString(R.string.development_hr)))
}

private fun createAbout(context: Context): BasicInformationItemRaw {
    return BasicInformationItemRaw(context.getString(R.string.about_project), StringLocale(context.getString(R.string.about_project_description_en)), StringLocale(context.getString(R.string.about_project_description_hr)), StringLocale(context.getString(R.string.about_meta_en)), StringLocale(context.getString(R.string.about_meta_hr)), R.drawable.img_nsb)
}

fun createInvestorsContactList(): RealmList<ContactRaw> {
    val result: RealmList<ContactRaw> = RealmList()
    result.add(ContactRaw("PT", R.drawable.ic_logo, "matija@solic.kralj", "+385 98 134 927"))
    return result
}

fun createTeamContactListHr(): RealmList<ContactRaw> {
    val result: RealmList<ContactRaw> = RealmList()
    result.add(ContactRaw("dr. sc. Sofija Klarin Zadravec", R.drawable.img_sofija, "sklarin@nsk.hr", "+385 1 616-4124"))
    result.add(ContactRaw("Dragana Koljenik", R.drawable.img_dragana, "dkoljenik@nsk.hr ", "+385 1 616-4356"))
    result.add(ContactRaw("Fotograf Darko Čižmek", R.drawable.img_darkec, "dcizmek@nsk.hr", "+385 1 616-4170"))
    return result
}

fun createTeamContactListEn(): RealmList<ContactRaw> {
    val result: RealmList<ContactRaw> = RealmList()
    result.add(ContactRaw("dr. sc. Sofija Klarin Zadravec", R.drawable.img_sofija, "sklarin@nsk.hr", "+385 1 616-4124"))
    result.add(ContactRaw("Dragana Koljenik", R.drawable.img_dragana, "dkoljenik@nsk.hr ", "+385 1 616-4356"))
    result.add(ContactRaw("Photographer Darko Čižmek", R.drawable.img_darkec, "dcizmek@nsk.hr", "+385 1 616-4170"))
    return result
}
