package uz.silence.fragmentpagerpracticecontinue.CLASS

class Category {

    var title: String? = null
    var imageList: ArrayList<Int>? = null


    constructor()
    constructor(title: String?, imageList: ArrayList<Int>?) {
        this.title = title
        this.imageList = imageList
    }

}