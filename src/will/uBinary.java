package will;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class uBinary {

    // Example
    public static void main(String args[]) {
        // Boolean variable (don't need create this)
        boolean boo = true;

        if (boo) {
            // Create new variable of uBinary class
            uBinary format = new uBinary(); // If you prefer declare UUID in construct = new uBinarry(UUID...);

            List<UUID> uuids = new ArrayList<UUID>();
            for (int i = 0; i < 2; i++) {
                uuids.add(UUID.randomUUID());
            }

            format.setUUIDs(uuids); // Declare uuid variable

            format.convertToBinary(); // Convert UUID to binary number

            System.out.println("Formatted: " + format.write()); // Use method .write() to return formatted binary number with your changes
        } else {
            // Convert without new variable
            System.out.println("Formatted: " +
                    new uBinary(UUID.randomUUID()).convertToBinary().write()
            );
        }
    }

    // UUID variable
    UUID uuid;

    // String variable
    String string;

    // UUID List variable
    List<UUID> luuid;

    // Formatted list variable
    List<String> formatted;

    // UUID to Binary construction
    public uBinary(UUID uuid) {
        this.uuid = uuid;

        luuid = new ArrayList<UUID>();
        formatted = new ArrayList<String>();
    }

    // UUID to Binary construction
    public uBinary(String uuid) {
        this.uuid = UUID.fromString(uuid);

        luuid = new ArrayList<UUID>();
        formatted = new ArrayList<String>();
    }

    // UUID to Binary construction
    public uBinary(List<UUID> uuid) {
        luuid = uuid;

        luuid = new ArrayList<UUID>();
        formatted = new ArrayList<String>();
    }

    // UUID to Binary construction
    public uBinary() {
        luuid = new ArrayList<UUID>();
        formatted = new ArrayList<String>();
    }

    // Clear class lists
    public uBinary clear() {
        luuid.clear();
        formatted.clear();
        return this;
    }

    // Set uuid variable by uuid
    public UUID setUUID(UUID uuid) { return this.uuid = uuid; }

    // Set uuid variable by string
    public UUID setUUID(String uuid) { return this.uuid = UUID.fromString(uuid); }

    // Set uuid list variable
    public List<UUID> setUUIDs(List<UUID> uuid) { return luuid = uuid; }

    // Return uuid variable
    public UUID getUUID() { return uuid; }

    // Return uuid list variable
    public List<UUID> getUUIDs() { return luuid; }

    // Convert uuid to binary by string
    public uBinary convertToBinary(String uuid) {
        byte[] uuidByte = uuid.getBytes();
        StringBuilder builder = new StringBuilder();

        for (byte b : uuidByte) {

            int value = b;
            for (int i = 0; i < 8; i++) {
                builder.append((value & 128) == 0 ? 0 : 1);
                value <<= 1;
            }

            builder.append(' ');
        }

        formatted.add(builder.toString());
        return this;
    }

    // Convert uuid to binary by uuid
    public uBinary convertToBinary() {
        if (!luuid.isEmpty()) {
            for (UUID uuid : luuid) {
                convertToBinary(uuid.toString());
            }
            return this;
        }
        convertToBinary(uuid.toString());
        return this;
    }

    // Convert binary to string
    public uBinary convertToString()  {
        for (String string : formatted) {
            String[] s = string.split(" ");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                builder.append((char) Integer.parseInt(s[i], 2));
            }

            this.string = builder.toString();
        }

        return this;
    }

    // Return formatted binary our string
    public String write() {
        if (string != null) {
            return string;
        }
        for (String string : formatted) {
            return string;
        }
        return null;
    }

}
