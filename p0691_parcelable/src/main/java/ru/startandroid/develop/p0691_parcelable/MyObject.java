package ru.startandroid.develop.p0691_parcelable;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MyObject implements Parcelable {
    final String s;
    public int i;

    //обычный конструктор
    @SuppressLint("RestrictedApi")
    public MyObject(String _s, int _i) {
        Log.d(LOG_TAG, "MyObject(String _s, int _i");
        s = _s;
        i = _i;
    }

    public int describeContents() {
        return 0;
    }

    // упаковываем объект в Parcel
    public void writeToParcel(Parcel parcel, int flags) {
        Log.d(LOG_TAG, "writeToParcel");
        parcel.writeString(s);
        parcel.writeInt(i);
    }

    public static final Parcelable.Creator<MyObject> CREATOR = new Parcelable.Creator<MyObject>() {
        // распаковываем объект из Parcel
        public MyObject createFromParcel(Parcel in) {
            Log.d(LOG_TAG, "createFromParcel");
            return new MyObject(in);
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };

    // конструктор, считывабщий данные из Parcel
    private MyObject(Parcel parcel) {
        Log.d(LOG_TAG, "MyObject(Parcel parcel");
        s = parcel.readString();
        i = parcel.readInt();
    }
}
