package com.bits.sql;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by PSY on 2014/10/04.
 */
public class ByteArrayValueMapper implements SqlValueMapper<byte[]> {

    public byte[] apply(Serializable serializable) {
        if (serializable instanceof byte[]) {
            return (byte[]) serializable;
        }
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bao)) {
            oos.writeObject(serializable);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return bao.toByteArray();
    }
}
