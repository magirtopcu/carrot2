
/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2015, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * http://www.carrot2.org/carrot2.LICENSE
 */

package org.carrot2.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Utilities for working with {@link Map}s.
 */
public class MapUtils
{
    private MapUtils()
    {
    }

    public static <K, V> HashMap<K, V> asHashMap(Map<K, V> map)
    {
        if (map instanceof HashMap)
        {
            return (HashMap<K, V>) map;
        }
        else
        {
            return new HashMap<K, V>(map);
        }
    }

    public static <K> Integer increment(Map<K, Integer> map, K key)
    {
        return increment(map, key, 1);
    }

    public static <K> Integer increment(Map<K, Integer> map, K key, int value)
    {
        final Integer current = map.get(key);
        if (current == null)
        {
            map.put(key, value);
            return value;
        }
        else
        {
            map.put(key, current + value);
            return current + value;
        }
    }
}
