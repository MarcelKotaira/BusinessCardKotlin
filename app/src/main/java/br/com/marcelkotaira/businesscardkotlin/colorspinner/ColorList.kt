package br.com.marcelkotaira.businesscardkotlin.colorspinner

class ColorList
{
    private val blackHex = "000000"
    private val whiteHex = "FFFFFF"

    val defaultColor: ColorObject = basicColors()[0]

    fun colorPosition(colorObject: ColorObject): Int
    {
        for (i in basicColors().indices)
        {
            if(colorObject == basicColors()[i])
                return i
        }
        return 0
    }

    fun basicColors(): List<ColorObject>
    {
        return listOf(
            ColorObject("Preto", blackHex, whiteHex),
            ColorObject("Prata", "C0C0C0", blackHex),
            ColorObject("Cinza", "808080", whiteHex),
            ColorObject("Bordo", "800000", whiteHex),
            ColorObject("Vermelho", "FF0000", whiteHex),
            ColorObject("Fuchsia", "FF00FF", whiteHex),
            ColorObject("Rosa", "FFCBDB", blackHex),
            ColorObject("Verde", "008000", whiteHex),
            ColorObject("Lime", "00FF00", blackHex),
            ColorObject("Olive", "808000", whiteHex),
            ColorObject("Amarelo", "FFFF00", blackHex),
            ColorObject("Navy", "000080", whiteHex),
            ColorObject("Azul", "0000FF", whiteHex),
            ColorObject("Teal", "008080", whiteHex),
            ColorObject("Aqua", "00FFFF", blackHex)
        )
    }
}