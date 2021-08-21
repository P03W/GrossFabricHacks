package net.gudenau.lib.unsafe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.logging.Logger;

@SuppressWarnings({"unchecked", "unused", "RedundantSuppression", "ConstantConditions", "SameParameterValue", "UnusedReturnValue"})
public class Unsafe {
    public static final MethodHandles.Lookup trustedLookup;
    public static final Class<?> SunUnsafe;
    public static final Class<?> Unsafe;
    public static final Object theSunUnsafe;
    public static final Object theUnsafe;
    
    public static final int ARRAY_BOOLEAN_BASE_OFFSET;
    public static final int ARRAY_BYTE_BASE_OFFSET;
    public static final int ARRAY_SHORT_BASE_OFFSET;
    public static final int ARRAY_CHAR_BASE_OFFSET;
    public static final int ARRAY_INT_BASE_OFFSET;
    public static final int ARRAY_LONG_BASE_OFFSET;
    public static final int ARRAY_FLOAT_BASE_OFFSET;
    public static final int ARRAY_DOUBLE_BASE_OFFSET;
    public static final int ARRAY_OBJECT_BASE_OFFSET;
    
    public static final int ARRAY_BOOLEAN_INDEX_SCALE;
    public static final int ARRAY_BYTE_INDEX_SCALE;
    public static final int ARRAY_SHORT_INDEX_SCALE;
    public static final int ARRAY_CHAR_INDEX_SCALE;
    public static final int ARRAY_INT_INDEX_SCALE;
    public static final int ARRAY_LONG_INDEX_SCALE;
    public static final int ARRAY_FLOAT_INDEX_SCALE;
    public static final int ARRAY_DOUBLE_INDEX_SCALE;
    public static final int ARRAY_OBJECT_INDEX_SCALE;
    
    public static final int ADDRESS_SIZE;
    
    public static final int INVALID_FIELD_OFFSET = -1;
    
    private static final MethodHandle getObjectInt;
    private static final MethodHandle putObjectInt;
    private static final MethodHandle getObjectObject;
    private static final MethodHandle putObjectObject;
    private static final MethodHandle getObjectBoolean;
    private static final MethodHandle putObjectBoolean;
    private static final MethodHandle getObjectByte;
    private static final MethodHandle putObjectByte;
    private static final MethodHandle getObjectShort;
    private static final MethodHandle putObjectShort;
    private static final MethodHandle getObjectChar;
    private static final MethodHandle putObjectChar;
    private static final MethodHandle getObjectLong;
    private static final MethodHandle putObjectLong;
    private static final MethodHandle getObjectFloat;
    private static final MethodHandle putObjectFloat;
    private static final MethodHandle getObjectDouble;
    private static final MethodHandle putObjectDouble;
    private static final MethodHandle getByte;
    private static final MethodHandle putByte;
    private static final MethodHandle getShort;
    private static final MethodHandle putShort;
    private static final MethodHandle getChar;
    private static final MethodHandle putChar;
    private static final MethodHandle getInt;
    private static final MethodHandle putInt;
    private static final MethodHandle getLong;
    private static final MethodHandle putLong;
    private static final MethodHandle getFloat;
    private static final MethodHandle putFloat;
    private static final MethodHandle getDouble;
    private static final MethodHandle putDouble;
    private static final MethodHandle getAddress;
    private static final MethodHandle putAddress;
    private static final MethodHandle allocateMemory;
    private static final MethodHandle reallocateMemory;
    private static final MethodHandle setObjectMemory;
    private static final MethodHandle setMemory;
    private static final MethodHandle copyObjectMemory;
    private static final MethodHandle copyMemory;
    private static final MethodHandle freeMemory;
    private static final MethodHandle objectFieldOffset;
    private static final MethodHandle staticFieldOffset;
    private static final MethodHandle staticFieldBase;
    private static final MethodHandle shouldBeInitialized;
    private static final MethodHandle ensureClassInitialized;
    private static final MethodHandle arrayBaseOffset;
    private static final MethodHandle arrayIndexScale;
    private static final MethodHandle addressSize;
    private static final MethodHandle pageSize;
    private static final MethodHandle defineClass;
    private static final MethodHandle defineAnonymousClass;
    private static final MethodHandle allocateInstance;
    private static final MethodHandle throwException;
    private static final MethodHandle compareAndSwapObject;
    private static final MethodHandle compareAndSwapInt;
    private static final MethodHandle compareAndSwapLong;
    private static final MethodHandle getObjectVolatile;
    private static final MethodHandle putObjectVolatile;
    private static final MethodHandle getIntVolatile;
    private static final MethodHandle putIntVolatile;
    private static final MethodHandle getBooleanVolatile;
    private static final MethodHandle putBooleanVolatile;
    private static final MethodHandle getByteVolatile;
    private static final MethodHandle putByteVolatile;
    private static final MethodHandle getShortVolatile;
    private static final MethodHandle putShortVolatile;
    private static final MethodHandle getCharVolatile;
    private static final MethodHandle putCharVolatile;
    private static final MethodHandle getLongVolatile;
    private static final MethodHandle putLongVolatile;
    private static final MethodHandle getFloatVolatile;
    private static final MethodHandle putFloatVolatile;
    private static final MethodHandle getDoubleVolatile;
    private static final MethodHandle putDoubleVolatile;
    private static final MethodHandle putOrderedObject;
    private static final MethodHandle putOrderedInt;
    private static final MethodHandle putOrderedLong;
    private static final MethodHandle unpark;
    private static final MethodHandle park;
    private static final MethodHandle getLoadAverage;
    private static final MethodHandle getAndAddInt;
    private static final MethodHandle getAndAddLong;
    private static final MethodHandle getAndSetInt;
    private static final MethodHandle getAndSetLong;
    private static final MethodHandle getAndSetObject;
    private static final MethodHandle loadFence;
    private static final MethodHandle storeFence;
    private static final MethodHandle fullFence;
    private static final MethodHandle invokeCleaner;
    
    public static int getInt(Object o, long offset) {
        try {
            return (int) getObjectInt.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putInt(Object o, long offset, int x) {
        try {
            putObjectInt.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static Object getObject(Object o, long offset) {
        try {
            return getObjectObject.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putObject(Object o, long offset, Object x) {
        try {
            putObjectObject.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static boolean getBoolean(Object o, long offset) {
        try {
            return (boolean) getObjectBoolean.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putBoolean(Object o, long offset, boolean x) {
        try {
            putObjectBoolean.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static byte getByte(Object o, long offset) {
        try {
            return (byte) getObjectByte.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putByte(Object o, long offset, byte x) {
        try {
            putObjectByte.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static short getShort(Object o, long offset) {
        try {
            return (short) getObjectShort.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putShort(Object o, long offset, short x) {
        try {
            putObjectShort.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static char getChar(Object o, long offset) {
        try {
            return (char) getObjectChar.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putChar(Object o, long offset, char x) {
        try {
            putObjectChar.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static long getLong(Object o, long offset) {
        try {
            return (long) getObjectLong.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putLong(Object o, long offset, long x) {
        try {
            putObjectLong.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static float getFloat(Object o, long offset) {
        try {
            return (float) getObjectFloat.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putFloat(Object o, long offset, float x) {
        try {
            putObjectFloat.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static double getDouble(Object o, long offset) {
        try {
            return (double) getObjectDouble.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putDouble(Object o, long offset, double x) {
        try {
            putObjectDouble.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static byte getByte(long address) {
        try {
            return (byte) getByte.invokeExact(address);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putByte(long address, byte x) {
        try {
            putByte.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static short getShort(long address) {
        try {
            return (short) getShort.invokeExact(address);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putShort(long address, short x) {
        try {
            putShort.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static char getChar(long address) {
        try {
            return (char) getChar.invokeExact(address);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putChar(long address, char x) {
        try {
            putChar.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static int getInt(long address) {
        try {
            return (int) getInt.invokeExact(address);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putInt(long address, int x) {
        try {
            putInt.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static long getLong(long address) {
        try {
            return (long) getLong.invokeExact(address);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putLong(long address, long x) {
        try {
            putLong.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static float getFloat(long address) {
        try {
            return (float) getFloat.invokeExact(address);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putFloat(long address, float x) {
        try {
            putFloat.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static double getDouble(long address) {
        try {
            return (double) getDouble.invokeExact(address);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putDouble(long address, double x) {
        try {
            putDouble.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static long getAddress(long address) {
        try {
            return (long) getAddress.invokeExact(address);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putAddress(long address, long x) {
        try {
            putAddress.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static long allocateMemory(long bytes) {
        try {
            return (long) allocateMemory.invokeExact(bytes);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static long reallocateMemory(long address, long bytes) {
        try {
            return (long) reallocateMemory.invokeExact(address, bytes);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void setMemory(Object o, long offset, long bytes, byte value) {
        try {
            setObjectMemory.invokeExact(o, offset, bytes, value);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void setMemory(long address, long bytes, byte value) {
        try {
            setMemory.invokeExact(address, bytes, value);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void copyMemory(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes) {
        try {
            copyObjectMemory.invokeExact(srcBase, srcOffset, destBase, destOffset, bytes);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void copyMemory(final long srcAddress, final long destAddress, final long bytes) {
        try {
            copyMemory.invokeExact(srcAddress, destAddress, bytes);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void freeMemory(final long address) {
        try {
            freeMemory.invokeExact(address);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static long objectFieldOffset(final Field field) {
        try {
            return (long) objectFieldOffset.invokeExact(field);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static long staticFieldOffset(final Field field) {
        try {
            return (long) staticFieldOffset.invokeExact(field);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static Object staticFieldBase(final Field field) {
        try {
            return (Object) staticFieldBase.invokeExact(field);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static boolean shouldBeInitialized(final Class<?> klass) {
        try {
            return (boolean) shouldBeInitialized.invokeExact(klass);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void ensureClassInitialized(Class<?> c) {
        try {
            ensureClassInitialized.invokeExact(c);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static int arrayBaseOffset(Class<?> arrayClass) {
        try {
            return (int) arrayBaseOffset.invokeExact(arrayClass);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static <T> int arrayIndexScale(Class<T> arrayClass) {
        try {
            return (int) arrayIndexScale.invokeExact(arrayClass);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static int addressSize() {
        try {
            return (int) addressSize.invokeExact();
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static int pageSize() {
        try {
            return (int) pageSize.invokeExact();
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static <A> Class<A> defineAnonymousClass(Class<?> hostClass, byte[] data, Object[] cpPatches) {
        try {
            return (Class<A>) defineAnonymousClass.invokeExact(hostClass, data, cpPatches);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static <T> Class<T> defineClass(final String name, final byte[] bytecode, final int offset, final int length, final ClassLoader classLoader, final ProtectionDomain protectionDomain) {
        try {
            return (Class<T>) defineClass.invokeExact(name, bytecode, offset, length, classLoader, protectionDomain);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static <T> T allocateInstance(Class<T> cls) {
        try {
            return (T) allocateInstance.invokeExact(cls);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static RuntimeException throwException(final Throwable throwable) {
        return throw0(throwable);
    }
    
    private static <T extends Throwable> T throw0(Throwable throwable) throws T {
        throw (T) throwable;
    }
    
    public static boolean compareAndSwapObject(Object o, long offset, Object expected, Object x) {
        try {
            return (boolean) compareAndSwapObject.invokeExact(o, offset, expected, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static boolean compareAndSwapInt(Object o, long offset, int expected, int x) {
        try {
            return (boolean) compareAndSwapInt.invokeExact(o, offset, expected, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static boolean compareAndSwapLong(final Object object, final long offset, final long expected, final long x) {
        try {
            return (boolean) compareAndSwapLong.invokeExact(object, offset, expected, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static <T> T getObjectVolatile(final Object object, long offset) {
        try {
            return (T) getObjectVolatile.invokeExact(object, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putObjectVolatile(Object o, long offset, Object x) {
        try {
            putObjectVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static int getIntVolatile(Object o, long offset) {
        try {
            return (int) getIntVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putIntVolatile(Object o, long offset, int x) {
        try {
            putIntVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static boolean getBooleanVolatile(Object o, long offset) {
        try {
            return (boolean) getBooleanVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putBooleanVolatile(Object o, long offset, boolean x) {
        try {
            putBooleanVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static byte getByteVolatile(Object o, long offset) {
        try {
            return (byte) getByteVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putByteVolatile(Object o, long offset, byte x) {
        try {
            putByteVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static short getShortVolatile(Object o, long offset) {
        try {
            return (short) getShortVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putShortVolatile(Object o, long offset, short x) {
        try {
            putShortVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static char getCharVolatile(Object o, long offset) {
        try {
            return (char) getCharVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putCharVolatile(Object o, long offset, char x) {
        try {
            putCharVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static long getLongVolatile(Object o, long offset) {
        try {
            return (long) getLongVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putLongVolatile(Object o, long offset, long x) {
        try {
            putLongVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static float getFloatVolatile(Object o, long offset) {
        try {
            return (float) getFloatVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putFloatVolatile(Object o, long offset, float x) {
        try {
            putFloatVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static double getDoubleVolatile(Object o, long offset) {
        try {
            return (double) getDoubleVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putDoubleVolatile(Object o, long offset, double x) {
        try {
            putDoubleVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putOrderedObject(Object o, long offset, Object x) {
        try {
            putOrderedObject.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putOrderedInt(Object o, long offset, int x) {
        try {
            putOrderedInt.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void putOrderedLong(Object o, long offset, long x) {
        try {
            putOrderedLong.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void unpark(Object thread) {
        try {
            unpark.invokeExact(thread);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void park(boolean isAbsolute, long time) {
        try {
            park.invokeExact(isAbsolute, time);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static int getLoadAverage(double[] loadavg, int nelems) {
        try {
            return (int) getLoadAverage.invokeExact(loadavg, nelems);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static int getAndAddInt(Object o, long offset, int delta) {
        try {
            return (int) getAndAddInt.invokeExact(o, offset, delta);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static long getAndAddLong(Object o, long offset, long delta) {
        try {
            return (long) getAndAddLong.invokeExact(o, offset, delta);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static int getAndSetInt(Object o, long offset, int newValue) {
        try {
            return (int) getAndSetInt.invokeExact(o, offset, newValue);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static long getAndSetLong(Object o, long offset, long newValue) {
        try {
            return (long) getAndSetLong.invokeExact(o, offset, newValue);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static <T> T getAndSetObject(Object o, long offset, T newValue) {
        try {
            return (T) getAndSetObject.invokeExact(o, offset, (Object) newValue);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void loadFence() {
        try {
            loadFence.invokeExact();
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void storeFence() {
        try {
            storeFence.invokeExact();
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void fullFence() {
        try {
            fullFence.invokeExact();
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    public static void invokeCleaner(ByteBuffer directBuffer) {
        try {
            invokeCleaner.invokeExact(directBuffer);
        } catch (final Throwable throwable) {
            throw throwException(throwable);
        }
    }
    
    private static MethodHandle bindSilent(final String method, final Class<?> returnType, final Class<?>... parameterTypes) {
        try {
            try {
                return trustedLookup.bind(theUnsafe, method, MethodType.methodType(returnType, parameterTypes));
            } catch (final NoSuchMethodException exception) {
                return trustedLookup.bind(theUnsafe, method, MethodType.methodType(returnType, parameterTypes));
            }
        } catch (final Throwable throwable) {
            return null;
        }
    }
    
    private static MethodHandle bind(final String method, final Class<?> returnType, final Class<?>... parameterTypes) {
        try {
            try {
                return trustedLookup.bind(theUnsafe, method, MethodType.methodType(returnType, parameterTypes));
            } catch (final NoSuchMethodException exception) {
                return trustedLookup.bind(theSunUnsafe, method, MethodType.methodType(returnType, parameterTypes));
            }
        } catch (Throwable failed) {
            String parameterString = Arrays.toString(parameterTypes);
            
            Logger.getLogger("Unsafe").warning(String.format("Unable to access Unsafe method %s%s\n%s.", method, '(' + parameterString.substring(1, parameterString.length() - 1) + ')', failed));
            
            return null;
        }
    }
    
    static {
        try {
            SunUnsafe = Class.forName("sun.misc.Unsafe");
            Object temporaryUnsafe = null;
            
            for (Field field : SunUnsafe.getDeclaredFields()) {
                if (field.getModifiers() == (Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL) && field.getType() == SunUnsafe) {
                    field.setAccessible(true);
                    
                    temporaryUnsafe = field.get(null);
                    
                    if (temporaryUnsafe != null) {
                        break;
                    }
                }
            }
            
            theSunUnsafe = temporaryUnsafe;
            
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            
            trustedLookup = (MethodHandles.Lookup) (Object) lookup
                .bind(temporaryUnsafe, "getObject", MethodType.methodType(Object.class, Object.class, long.class))
                .invokeExact((Object) MethodHandles.Lookup.class, (long) lookup.bind(temporaryUnsafe, "staticFieldOffset", MethodType.methodType(long.class, Field.class))
                    .invokeExact(MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP")));
            
            String version = System.getProperty("java.version");
            boolean java9 = version.indexOf('.') != 1 || version.charAt(2) == '9';
            
            if (java9) {
                Unsafe = Class.forName("jdk.internal.misc.Unsafe");
                temporaryUnsafe = trustedLookup.findStatic(Unsafe, "getUnsafe", MethodType.methodType(Unsafe)).invoke();
            } else {
                Unsafe = SunUnsafe;
            }
            
            theUnsafe = temporaryUnsafe;
            
            getObjectInt = bind("getInt", int.class, Object.class, long.class);
            getObjectObject = bind("getObject", Object.class, Object.class, long.class);
            getObjectBoolean = bind("getBoolean", boolean.class, Object.class, long.class);
            getObjectByte = bind("getByte", byte.class, Object.class, long.class);
            getObjectShort = bind("getShort", short.class, Object.class, long.class);
            getObjectChar = bind("getChar", char.class, Object.class, long.class);
            getObjectLong = bind("getLong", long.class, Object.class, long.class);
            getObjectFloat = bind("getFloat", float.class, Object.class, long.class);
            getObjectDouble = bind("getDouble", double.class, Object.class, long.class);
            
            putObjectInt = bind("putInt", void.class, Object.class, long.class, int.class);
            putObjectObject = bind("putObject", void.class, Object.class, long.class, Object.class);
            putObjectBoolean = bind("putBoolean", void.class, Object.class, long.class, boolean.class);
            putObjectByte = bind("putByte", void.class, Object.class, long.class, byte.class);
            putObjectShort = bind("putShort", void.class, Object.class, long.class, short.class);
            putObjectChar = bind("putChar", void.class, Object.class, long.class, char.class);
            putObjectLong = bind("putLong", void.class, Object.class, long.class, long.class);
            putObjectFloat = bind("putFloat", void.class, Object.class, long.class, float.class);
            putObjectDouble = bind("putDouble", void.class, Object.class, long.class, double.class);
            
            getByte = bind("getByte", byte.class, long.class);
            getShort = bind("getShort", short.class, long.class);
            getChar = bind("getChar", char.class, long.class);
            getInt = bind("getInt", int.class, long.class);
            getLong = bind("getLong", long.class, long.class);
            getFloat = bind("getFloat", float.class, long.class);
            getDouble = bind("getDouble", double.class, long.class);
            getAddress = bind("getAddress", long.class, long.class);
            
            putByte = bind("putByte", void.class, long.class, byte.class);
            putShort = bind("putShort", void.class, long.class, short.class);
            putChar = bind("putChar", void.class, long.class, char.class);
            putInt = bind("putInt", void.class, long.class, int.class);
            putLong = bind("putLong", void.class, long.class, long.class);
            putFloat = bind("putFloat", void.class, long.class, float.class);
            putDouble = bind("putDouble", void.class, long.class, double.class);
            putAddress = bind("putAddress", void.class, long.class, long.class);
            
            allocateMemory = bind("allocateMemory", long.class, long.class);
            reallocateMemory = bind("reallocateMemory", long.class, long.class, long.class);
            setObjectMemory = bind("setMemory", void.class, Object.class, long.class, long.class, byte.class);
            setMemory = bind("setMemory", void.class, long.class, long.class, byte.class);
            copyObjectMemory = bind("copyMemory", void.class, Object.class, long.class, Object.class, long.class, long.class);
            copyMemory = bind("copyMemory", void.class, long.class, long.class, long.class);
            freeMemory = bind("freeMemory", void.class, long.class);
            objectFieldOffset = bind("objectFieldOffset", long.class, Field.class);
            staticFieldOffset = bind("staticFieldOffset", long.class, Field.class);
            staticFieldBase = bind("staticFieldBase", Object.class, Field.class);
            shouldBeInitialized = bind("shouldBeInitialized", boolean.class, Class.class);
            ensureClassInitialized = bind("ensureClassInitialized", void.class, Class.class);
            arrayBaseOffset = bind("arrayBaseOffset", int.class, Class.class);
            arrayIndexScale = bind("arrayIndexScale", int.class, Class.class);
            addressSize = bind("addressSize", int.class);
            pageSize = bind("pageSize", int.class);
            defineClass = bind("defineClass", Class.class, String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class);
            defineAnonymousClass = bind("defineAnonymousClass", Class.class, Class.class, byte[].class, Object[].class);
            allocateInstance = bind("allocateInstance", Object.class, Class.class);
            throwException = bind("throwException", void.class, Throwable.class);
            
            getObjectVolatile = bind("getObjectVolatile", Object.class, Object.class, long.class);
            getIntVolatile = bind("getIntVolatile", int.class, Object.class, long.class);
            getBooleanVolatile = bind("getBooleanVolatile", boolean.class, Object.class, long.class);
            getByteVolatile = bind("getByteVolatile", byte.class, Object.class, long.class);
            getShortVolatile = bind("getShortVolatile", short.class, Object.class, long.class);
            getCharVolatile = bind("getCharVolatile", char.class, Object.class, long.class);
            getLongVolatile = bind("getLongVolatile", long.class, Object.class, long.class);
            getFloatVolatile = bind("getFloatVolatile", float.class, Object.class, long.class);
            getDoubleVolatile = bind("getDoubleVolatile", double.class, Object.class, long.class);
            
            putObjectVolatile = bind("putObjectVolatile", void.class, Object.class, long.class, Object.class);
            putIntVolatile = bind("putIntVolatile", void.class, Object.class, long.class, int.class);
            putBooleanVolatile = bind("putBooleanVolatile", void.class, Object.class, long.class, boolean.class);
            putByteVolatile = bind("putByteVolatile", void.class, Object.class, long.class, byte.class);
            putShortVolatile = bind("putShortVolatile", void.class, Object.class, long.class, short.class);
            putCharVolatile = bind("putCharVolatile", void.class, Object.class, long.class, char.class);
            putLongVolatile = bind("putLongVolatile", void.class, Object.class, long.class, long.class);
            putFloatVolatile = bind("putFloatVolatile", void.class, Object.class, long.class, float.class);
            putDoubleVolatile = bind("putDoubleVolatile", void.class, Object.class, long.class, double.class);
            
            if (java9) {
                compareAndSwapObject = bind("compareAndSetObject", boolean.class, Object.class, long.class, Object.class, Object.class);
                compareAndSwapInt = bind("compareAndSetInt", boolean.class, Object.class, long.class, int.class, int.class);
                compareAndSwapLong = bind("compareAndSetLong", boolean.class, Object.class, long.class, long.class, long.class);
                
                final MethodHandle putReferenceRelease = bindSilent("putReferenceRelease", void.class, Object.class, long.class, Object.class);
                
                putOrderedObject = putReferenceRelease == null
                    ? bind("putObjectRelease", void.class, Object.class, long.class, Object.class)
                    : putReferenceRelease;
                
                putOrderedInt = bind("putIntRelease", void.class, Object.class, long.class, int.class);
                putOrderedLong = bind("putLongRelease", void.class, Object.class, long.class, long.class);
            } else {
                compareAndSwapObject = bind("compareAndSwapObject", boolean.class, Object.class, long.class, Object.class, Object.class);
                compareAndSwapInt = bind("compareAndSwapInt", boolean.class, Object.class, long.class, int.class, int.class);
                compareAndSwapLong = bind("compareAndSwapLong", boolean.class, Object.class, long.class, long.class, long.class);
                
                putOrderedObject = trustedLookup.bind(theUnsafe, "putOrderedObject", MethodType.methodType(void.class, Object.class, long.class, Object.class));
                putOrderedInt = trustedLookup.bind(theUnsafe, "putOrderedInt", MethodType.methodType(void.class, Object.class, long.class, int.class));
                putOrderedLong = trustedLookup.bind(theUnsafe, "putOrderedLong", MethodType.methodType(void.class, Object.class, long.class, long.class));
            }
            
            unpark = bind("unpark", void.class, Object.class);
            park = bind("park", void.class, boolean.class, long.class);
            
            getLoadAverage = bind("getLoadAverage", int.class, double[].class, int.class);
            getAndAddInt = bind("getAndAddInt", int.class, Object.class, long.class, int.class);
            getAndAddLong = bind("getAndAddLong", long.class, Object.class, long.class, long.class);
            getAndSetInt = bind("getAndSetInt", int.class, Object.class, long.class, int.class);
            getAndSetLong = bind("getAndSetLong", long.class, Object.class, long.class, long.class);
            getAndSetObject = bind("getAndSetObject", Object.class, Object.class, long.class, Object.class);
            
            loadFence = bind("loadFence", void.class);
            storeFence = bind("storeFence", void.class);
            fullFence = bind("fullFence", void.class);
            
            invokeCleaner = bindSilent("invokeCleaner", void.class, ByteBuffer.class);
            
            ARRAY_BOOLEAN_BASE_OFFSET = arrayBaseOffset(boolean[].class);
            ARRAY_BYTE_BASE_OFFSET = arrayBaseOffset(byte[].class);
            ARRAY_SHORT_BASE_OFFSET = arrayBaseOffset(short[].class);
            ARRAY_CHAR_BASE_OFFSET = arrayBaseOffset(char[].class);
            ARRAY_INT_BASE_OFFSET = arrayBaseOffset(int[].class);
            ARRAY_LONG_BASE_OFFSET = arrayBaseOffset(long[].class);
            ARRAY_FLOAT_BASE_OFFSET = arrayBaseOffset(float[].class);
            ARRAY_DOUBLE_BASE_OFFSET = arrayBaseOffset(double[].class);
            ARRAY_OBJECT_BASE_OFFSET = arrayBaseOffset(Object[].class);
            
            ARRAY_BOOLEAN_INDEX_SCALE = arrayIndexScale(boolean[].class);
            ARRAY_BYTE_INDEX_SCALE = arrayIndexScale(byte[].class);
            ARRAY_SHORT_INDEX_SCALE = arrayIndexScale(short[].class);
            ARRAY_CHAR_INDEX_SCALE = arrayIndexScale(char[].class);
            ARRAY_INT_INDEX_SCALE = arrayIndexScale(int[].class);
            ARRAY_LONG_INDEX_SCALE = arrayIndexScale(long[].class);
            ARRAY_FLOAT_INDEX_SCALE = arrayIndexScale(float[].class);
            ARRAY_DOUBLE_INDEX_SCALE = arrayIndexScale(double[].class);
            ARRAY_OBJECT_INDEX_SCALE = arrayIndexScale(Object[].class);
            
            ADDRESS_SIZE = addressSize();
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }
}
