package com.example.android.basicconcept.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mark63 on 20/4/17.
 */

public class Model implements Parcelable {


    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(final Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(final int size) {
            return new Model[size];
        }
    };

    private String itemname;

    /**
     * @param itemname itemname is set here to itemname variable
     */
    public Model(final String itemname) {

        this.itemname = itemname;
    }

    /**
     * @param in item name is input here or readed
     */
    protected Model(final Parcel in) {
        itemname = in.readString();


    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(itemname);

    }

    /**
     * @return item name is returned
     */
    public String getItemname() {
        return itemname;
    }


}
