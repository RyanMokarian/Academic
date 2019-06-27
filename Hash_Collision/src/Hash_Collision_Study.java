/*
Title: Hash collision study to compare probing algorithms
Category: Data Structure
Author: Ryan Mokarian

Task:
Use the words given above in Q1 to create a hash table of appropriate size to be about 70% full.
The hash conversion is by using the character position in an 26 character alphabet using the folding
method(A-Z, with A having the value 1 and Z having the value 26).
For example the word YOU is converted to the numeric value 25+15+21=61; then 61 is used to map
the key to a slot in the hash table.
Use the following collision resolution schemes presented in class:

Separate Chaining
Linear Probing
Quadratic Probing
Double Hashing
Show for each scheme the hash table and any supplementary structure. For each, give the average number
of probes to search each word in the list.

 */


import java.util.LinkedList;
        import java.util.List;

public class Hash_Collision_Study {

    public static void main(String[] args) {
        String str = "YOU GOT TO HAVE FUN BUT YOU NEED TO KNOW HOW SAID THE CAT IN THE HAT";
        String[] keys = str.split(" ");
        int[] values = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            values[i] = hashCodeCalculator(keys[i]);
            //System.out.println(keys[i]+" = "+values[i]);
            //values[i] = keys[i].hashCode();
        }
        int hashSize = 23;
        List[] map = separateChaining(keys, values, hashSize);
        HashStrucrure[] mapLinear = linearProbing(keys, values, hashSize);
        HashStrucrure[] mapQuadratic = quadraticProbing(keys, values, hashSize);
        HashStrucrure[] doubleHashing = doubleHashing(keys, values, hashSize);
        System.out.println("Separate Chaining:");
        showMap(map);
        System.out.println("Linear Probing:");
        showMap(mapLinear);
        System.out.println("Quadratic Probing:");
        showMap(mapQuadratic);
        System.out.println("Double Hashing:");
        showMap(doubleHashing);

    }

    private static int hashCodeCalculator(String key) {
        int n =0;
        String keyLowerCase = key.toLowerCase();
        for (int i = 0; i < key.length(); ++i) {
            char ch = keyLowerCase.charAt(i);
            n += (int)ch - (int)'a' + 1;
        }
        return n;
    }

    public static HashStrucrure[] doubleHashing(final String[] keys, int[] values, int hashSize) {

        HashStrucrure[] map = new HashStrucrure[hashSize];

        for (int i = 0; i < keys.length; i++) {
            if (map[values[i] % hashSize] == null) {
                HashStrucrure hashStrucrure = new HashStrucrure();
                hashStrucrure.setKey(keys[i]);
                hashStrucrure.setProb(1);
                map[values[i] % hashSize] = hashStrucrure;
            } else {
                map[values[i] % hashSize].setProb(map[values[i] % hashSize].getProb() + 1);
                shiftToRightAndInsertStringDoubleHashing(map, i, values, keys[i], hashSize);
            }
        }
        return map;
    }

    public static HashStrucrure[] linearProbing(final String[] keys, int[] values, int hashSize) {

        HashStrucrure[] map = new HashStrucrure[hashSize];

        for (int i = 0; i < keys.length; i++) {
            if (map[values[i] % hashSize] == null) {
                HashStrucrure hashStrucrure = new HashStrucrure();
                hashStrucrure.setKey(keys[i]);
                hashStrucrure.setProb(1);
                map[values[i] % hashSize] = hashStrucrure;
            } else {
                map[values[i] % hashSize].setProb(map[values[i] % hashSize].getProb() + 1);
                shiftToRightAndInsertString(map, i, values, keys[i], hashSize);
            }
        }
        return map;
    }

    public static HashStrucrure[] quadraticProbing(final String[] keys, int[] values, int hashSize) {

        HashStrucrure[] map = new HashStrucrure[hashSize];

        for (int i = 0; i < keys.length; i++) {
            if (map[values[i] % hashSize] == null) {
                HashStrucrure hashStrucrure = new HashStrucrure();
                hashStrucrure.setKey(keys[i]);
                hashStrucrure.setProb(1);
                map[values[i] % hashSize] = hashStrucrure;
            } else {
                map[values[i] % hashSize].setProb(map[values[i] % hashSize].getProb() + 1);
                shiftToRightAndInsertStringQuadratic(map, i, values, keys[i], hashSize);
            }
        }
        return map;
    }

    public static void shiftToRightAndInsertStringDoubleHashing(HashStrucrure[] map, int index, int[] values, String key, int hashSize) {

        for (int i = 0; i < map.length; i++) {
            int step = values[index] % 7;
            if (map[(((values[index]) % hashSize) + (i * step)) % hashSize] == null) {
                HashStrucrure hashStrucrure = new HashStrucrure();
                hashStrucrure.setKey(key);
                hashStrucrure.setProb(1);
                map[(((values[index]) % hashSize) + (i * step)) % hashSize] = hashStrucrure;
                break;
            }
        }
    }

    public static void shiftToRightAndInsertString(HashStrucrure[] map, int index, int[] values, String key, int hashSize) {

        for (int i = 0; i < map.length; i++) {
            if (map[(((values[index]) % hashSize) + i) % hashSize] == null) {
                HashStrucrure hashStrucrure = new HashStrucrure();
                hashStrucrure.setKey(key);
                hashStrucrure.setProb(1);
                map[(((values[index]) % hashSize) + i) % hashSize] = hashStrucrure;
                break;
            }
        }
    }

    public static void shiftToRightAndInsertStringQuadratic(HashStrucrure[] map, int index, int[] values, String key, int hashSize) {

        for (int i = 0; i < map.length; i++) {
            if (map[(((values[index]) % hashSize) + (i ^ 2)) % hashSize] == null) {
                HashStrucrure hashStrucrure = new HashStrucrure();
                hashStrucrure.setKey(key);
                hashStrucrure.setProb(1);
                map[(((values[index]) % hashSize) + (i ^ 2)) % hashSize] = hashStrucrure;
                break;
            }
        }
    }


    public static List[] separateChaining(final String[] keys, int[] values, int hashSize) {

        List[] map = new List[hashSize];
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList();
        }

        for (int i = 0; i < keys.length; i++) {
            if (!map[values[i] % hashSize].contains(keys[i])) {
                map[values[i] % hashSize].add(keys[i]);
            }
        }
        return map;
    }

    private static void showMap(List[] map) {
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            String value = map[i] == null ? "''" : map[i].toString();
            System.out.print(i + "=" + value);
            sum += map[i] == null ? 0 : map[i].size();
        }
        System.out.println();
        System.out.println("Average number of probs for failures was: " + round(Double.valueOf(sum) / map.length, 2));
        System.out.println();
    }

    private static void showMap(HashStrucrure[] map) {
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            String value = map[i] == null ? "''" : map[i].toString();
            System.out.print(i + "=" + value + ",");
            sum += map[i] == null ? 0 : map[i].getProb();
        }
        System.out.println();
        System.out.println("Average number of probs for failures was: " + round(Double.valueOf(sum) / map.length, 2));
        System.out.println();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


}


