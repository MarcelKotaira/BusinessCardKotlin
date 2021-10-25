package br.com.marcelkotaira.businesscardkotlin.colorspinner

class ColorObject(var name: String, var hex: String, var contrastHex: String)
{
    val hexHash : String = "#$hex"
    val contrastHexHash : String = "#$contrastHex"
    val hexHashAlpha : String = "#FF$hex"
}