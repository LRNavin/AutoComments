public static byte[] bitmapToByte(Bitmap b){
    ByteArrayOutputStream o = new ByteArrayOutputStream();
    b.compress(Bitmap.CompressFormat.PNG,100,o);
    return o.toByteArray();
}