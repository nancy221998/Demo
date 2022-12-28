package com.amaze.demoproject.modal

import android.content.Context

object DummyData {
        fun getDummyData(context: Context): MutableList<ImageModel> {
            val imageList = arrayListOf<ImageModel>()
            var image = listOf<String>("https://images.freecreatives.com/wp-content/uploads/2016/03/Gren-Nature-background-1.jpg")
            var image2 = listOf<String>("https://wallup.net/wp-content/uploads/2016/01/138020-nature-forest-river.jpg", "https://dummyimage.com/300.png/09f/fff")
            var image3 = listOf<String>("https://jooinn.com/images/nature-339.jpg", "https://i.pinimg.com/originals/65/06/ab/6506abcd0866d885bbdfe47ee920a56f.png","https://dummyimage.com/300.png/09f/fff")
            var image4 = listOf<String>("https://i.pinimg.com/originals/b5/9a/d8/b59ad8de32701b02d1abb870a8a44204.jpg", "https://i.pinimg.com/originals/65/06/ab/6506abcd0866d885bbdfe47ee920a56f.png","https://dummyimage.com/300.png/09f/fff")

            val imageBinding1 = ImageModel(
                image,
                "NewImageGallery",
                "19/01/23 12:15:14",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis."
                )

            val imageBinding2 = ImageModel(
                image2,
                "OldImageGallery",
                "20/01/23 10:15:14",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis."
            )

            val imageBinding3 = ImageModel(
                image3,
                "TestImageGallery",
                "21/01/22 12:15:08",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis."
            )

            val imageBinding4 = ImageModel(
                image4,
                "LiveImageGallery",
                        "22/01/22 12:05:08",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis."
            )

            imageList.add(imageBinding1)
            imageList.add(imageBinding2)
            imageList.add(imageBinding3)
            imageList.add(imageBinding4)

            return imageList

        }
    }
