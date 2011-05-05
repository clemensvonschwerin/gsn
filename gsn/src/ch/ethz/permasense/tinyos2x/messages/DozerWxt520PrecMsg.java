/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'DozerWxt520PrecMsg'
 * message type.
 */

package ch.ethz.permasense.tinyos2x.messages;

public class DozerWxt520PrecMsg extends ch.ethz.permasense.tinyos2x.messages.DataHeaderMsg {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 29;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 148;

    /** Create a new DozerWxt520PrecMsg of size 29. */
    public DozerWxt520PrecMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new DozerWxt520PrecMsg of the given data_length. */
    public DozerWxt520PrecMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DozerWxt520PrecMsg with the given data_length
     * and base offset.
     */
    public DozerWxt520PrecMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DozerWxt520PrecMsg using the given byte array
     * as backing store.
     */
    public DozerWxt520PrecMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DozerWxt520PrecMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public DozerWxt520PrecMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DozerWxt520PrecMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public DozerWxt520PrecMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DozerWxt520PrecMsg embedded in the given message
     * at the given base offset.
     */
    public DozerWxt520PrecMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new DozerWxt520PrecMsg embedded in the given message
     * at the given base offset and length.
     */
    public DozerWxt520PrecMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <DozerWxt520PrecMsg> \n";
      try {
        s += "  [header.seqNr=0x"+Long.toHexString(get_header_seqNr())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [header.originatorID=0x"+Long.toHexString(get_header_originatorID())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [header.aTime.low=0x"+Long.toHexString(get_header_aTime_low())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [header.aTime.high=0x"+Long.toHexString(get_header_aTime_high())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [payload.sample.valid=0x"+Long.toHexString(get_payload_sample_valid())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [payload.sample.no=0x"+Long.toHexString(get_payload_sample_no())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [payload.Ru_Rc=0x"+Long.toHexString(get_payload_Ru_Rc())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [payload.Ru_Rd=0x"+Long.toHexString(get_payload_Ru_Rd())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [payload.Ru_Ri=0x"+Long.toHexString(get_payload_Ru_Ri())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [payload.Ru_Hc=0x"+Long.toHexString(get_payload_Ru_Hc())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [payload.Ru_Hd=0x"+Long.toHexString(get_payload_Ru_Hd())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [payload.Ru_Hi=0x"+Long.toHexString(get_payload_Ru_Hi())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [payload.Ru_Rp=0x"+Long.toHexString(get_payload_Ru_Rp())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [payload.Ru_Hp=0x"+Long.toHexString(get_payload_Ru_Hp())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: header.seqNr
    //   Field type: int
    //   Offset (bits): 0
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'header.seqNr' is signed (false).
     */
    public static boolean isSigned_header_seqNr() {
        return false;
    }

    /**
     * Return whether the field 'header.seqNr' is an array (false).
     */
    public static boolean isArray_header_seqNr() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'header.seqNr'
     */
    public static int offset_header_seqNr() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'header.seqNr'
     */
    public static int offsetBits_header_seqNr() {
        return 0;
    }

    /**
     * Return the value (as a int) of the field 'header.seqNr'
     */
    public int get_header_seqNr() {
        return (int)getUIntBEElement(offsetBits_header_seqNr(), 16);
    }

    /**
     * Set the value of the field 'header.seqNr'
     */
    public void set_header_seqNr(int value) {
        setUIntBEElement(offsetBits_header_seqNr(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'header.seqNr'
     */
    public static int size_header_seqNr() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'header.seqNr'
     */
    public static int sizeBits_header_seqNr() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: header.originatorID
    //   Field type: int
    //   Offset (bits): 16
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'header.originatorID' is signed (false).
     */
    public static boolean isSigned_header_originatorID() {
        return false;
    }

    /**
     * Return whether the field 'header.originatorID' is an array (false).
     */
    public static boolean isArray_header_originatorID() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'header.originatorID'
     */
    public static int offset_header_originatorID() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'header.originatorID'
     */
    public static int offsetBits_header_originatorID() {
        return 16;
    }

    /**
     * Return the value (as a int) of the field 'header.originatorID'
     */
    public int get_header_originatorID() {
        return (int)getUIntBEElement(offsetBits_header_originatorID(), 16);
    }

    /**
     * Set the value of the field 'header.originatorID'
     */
    public void set_header_originatorID(int value) {
        setUIntBEElement(offsetBits_header_originatorID(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'header.originatorID'
     */
    public static int size_header_originatorID() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'header.originatorID'
     */
    public static int sizeBits_header_originatorID() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: header.aTime.low
    //   Field type: int
    //   Offset (bits): 32
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'header.aTime.low' is signed (false).
     */
    public static boolean isSigned_header_aTime_low() {
        return false;
    }

    /**
     * Return whether the field 'header.aTime.low' is an array (false).
     */
    public static boolean isArray_header_aTime_low() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'header.aTime.low'
     */
    public static int offset_header_aTime_low() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'header.aTime.low'
     */
    public static int offsetBits_header_aTime_low() {
        return 32;
    }

    /**
     * Return the value (as a int) of the field 'header.aTime.low'
     */
    public int get_header_aTime_low() {
        return (int)getUIntBEElement(offsetBits_header_aTime_low(), 16);
    }

    /**
     * Set the value of the field 'header.aTime.low'
     */
    public void set_header_aTime_low(int value) {
        setUIntBEElement(offsetBits_header_aTime_low(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'header.aTime.low'
     */
    public static int size_header_aTime_low() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'header.aTime.low'
     */
    public static int sizeBits_header_aTime_low() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: header.aTime.high
    //   Field type: short
    //   Offset (bits): 48
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'header.aTime.high' is signed (false).
     */
    public static boolean isSigned_header_aTime_high() {
        return false;
    }

    /**
     * Return whether the field 'header.aTime.high' is an array (false).
     */
    public static boolean isArray_header_aTime_high() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'header.aTime.high'
     */
    public static int offset_header_aTime_high() {
        return (48 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'header.aTime.high'
     */
    public static int offsetBits_header_aTime_high() {
        return 48;
    }

    /**
     * Return the value (as a short) of the field 'header.aTime.high'
     */
    public short get_header_aTime_high() {
        return (short)getUIntBEElement(offsetBits_header_aTime_high(), 8);
    }

    /**
     * Set the value of the field 'header.aTime.high'
     */
    public void set_header_aTime_high(short value) {
        setUIntBEElement(offsetBits_header_aTime_high(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'header.aTime.high'
     */
    public static int size_header_aTime_high() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'header.aTime.high'
     */
    public static int sizeBits_header_aTime_high() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: payload.sample.valid
    //   Field type: byte
    //   Offset (bits): 56
    //   Size (bits): 1
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'payload.sample.valid' is signed (false).
     */
    public static boolean isSigned_payload_sample_valid() {
        return false;
    }

    /**
     * Return whether the field 'payload.sample.valid' is an array (false).
     */
    public static boolean isArray_payload_sample_valid() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'payload.sample.valid'
     */
    public static int offset_payload_sample_valid() {
        return (56 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'payload.sample.valid'
     */
    public static int offsetBits_payload_sample_valid() {
        return 56;
    }

    /**
     * Return the value (as a byte) of the field 'payload.sample.valid'
     */
    public byte get_payload_sample_valid() {
        return (byte)getUIntBEElement(offsetBits_payload_sample_valid(), 1);
    }

    /**
     * Set the value of the field 'payload.sample.valid'
     */
    public void set_payload_sample_valid(byte value) {
        setUIntBEElement(offsetBits_payload_sample_valid(), 1, value);
    }

    /**
     * Return the size, in bytes, of the field 'payload.sample.valid'
     * WARNING: This field is not an even-sized number of bytes (1 bits).
     */
    public static int size_payload_sample_valid() {
        return (1 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'payload.sample.valid'
     */
    public static int sizeBits_payload_sample_valid() {
        return 1;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: payload.sample.no
    //   Field type: short
    //   Offset (bits): 57
    //   Size (bits): 15
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'payload.sample.no' is signed (false).
     */
    public static boolean isSigned_payload_sample_no() {
        return false;
    }

    /**
     * Return whether the field 'payload.sample.no' is an array (false).
     */
    public static boolean isArray_payload_sample_no() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'payload.sample.no'
     * WARNING: This field is not byte-aligned (bit offset 57).
     */
    public static int offset_payload_sample_no() {
        return (57 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'payload.sample.no'
     */
    public static int offsetBits_payload_sample_no() {
        return 57;
    }

    /**
     * Return the value (as a short) of the field 'payload.sample.no'
     */
    public short get_payload_sample_no() {
        return (short)getUIntBEElement(offsetBits_payload_sample_no(), 15);
    }

    /**
     * Set the value of the field 'payload.sample.no'
     */
    public void set_payload_sample_no(short value) {
        setUIntBEElement(offsetBits_payload_sample_no(), 15, value);
    }

    /**
     * Return the size, in bytes, of the field 'payload.sample.no'
     * WARNING: This field is not an even-sized number of bytes (15 bits).
     */
    public static int size_payload_sample_no() {
        return (15 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'payload.sample.no'
     */
    public static int sizeBits_payload_sample_no() {
        return 15;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: payload.Ru_Rc
    //   Field type: short
    //   Offset (bits): 72
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'payload.Ru_Rc' is signed (false).
     */
    public static boolean isSigned_payload_Ru_Rc() {
        return false;
    }

    /**
     * Return whether the field 'payload.Ru_Rc' is an array (false).
     */
    public static boolean isArray_payload_Ru_Rc() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'payload.Ru_Rc'
     */
    public static int offset_payload_Ru_Rc() {
        return (72 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'payload.Ru_Rc'
     */
    public static int offsetBits_payload_Ru_Rc() {
        return 72;
    }

    /**
     * Return the value (as a short) of the field 'payload.Ru_Rc'
     */
    public short get_payload_Ru_Rc() {
        return (short)getSIntBEElement(offsetBits_payload_Ru_Rc(), 16);
    }

    /**
     * Set the value of the field 'payload.Ru_Rc'
     */
    public void set_payload_Ru_Rc(short value) {
        setSIntBEElement(offsetBits_payload_Ru_Rc(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'payload.Ru_Rc'
     */
    public static int size_payload_Ru_Rc() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'payload.Ru_Rc'
     */
    public static int sizeBits_payload_Ru_Rc() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: payload.Ru_Rd
    //   Field type: int
    //   Offset (bits): 88
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'payload.Ru_Rd' is signed (false).
     */
    public static boolean isSigned_payload_Ru_Rd() {
        return false;
    }

    /**
     * Return whether the field 'payload.Ru_Rd' is an array (false).
     */
    public static boolean isArray_payload_Ru_Rd() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'payload.Ru_Rd'
     */
    public static int offset_payload_Ru_Rd() {
        return (88 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'payload.Ru_Rd'
     */
    public static int offsetBits_payload_Ru_Rd() {
        return 88;
    }

    /**
     * Return the value (as a int) of the field 'payload.Ru_Rd'
     */
    public int get_payload_Ru_Rd() {
        return (int)getSIntBEElement(offsetBits_payload_Ru_Rd(), 32);
    }

    /**
     * Set the value of the field 'payload.Ru_Rd'
     */
    public void set_payload_Ru_Rd(int value) {
        setSIntBEElement(offsetBits_payload_Ru_Rd(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'payload.Ru_Rd'
     */
    public static int size_payload_Ru_Rd() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'payload.Ru_Rd'
     */
    public static int sizeBits_payload_Ru_Rd() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: payload.Ru_Ri
    //   Field type: short
    //   Offset (bits): 120
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'payload.Ru_Ri' is signed (false).
     */
    public static boolean isSigned_payload_Ru_Ri() {
        return false;
    }

    /**
     * Return whether the field 'payload.Ru_Ri' is an array (false).
     */
    public static boolean isArray_payload_Ru_Ri() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'payload.Ru_Ri'
     */
    public static int offset_payload_Ru_Ri() {
        return (120 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'payload.Ru_Ri'
     */
    public static int offsetBits_payload_Ru_Ri() {
        return 120;
    }

    /**
     * Return the value (as a short) of the field 'payload.Ru_Ri'
     */
    public short get_payload_Ru_Ri() {
        return (short)getSIntBEElement(offsetBits_payload_Ru_Ri(), 16);
    }

    /**
     * Set the value of the field 'payload.Ru_Ri'
     */
    public void set_payload_Ru_Ri(short value) {
        setSIntBEElement(offsetBits_payload_Ru_Ri(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'payload.Ru_Ri'
     */
    public static int size_payload_Ru_Ri() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'payload.Ru_Ri'
     */
    public static int sizeBits_payload_Ru_Ri() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: payload.Ru_Hc
    //   Field type: short
    //   Offset (bits): 136
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'payload.Ru_Hc' is signed (false).
     */
    public static boolean isSigned_payload_Ru_Hc() {
        return false;
    }

    /**
     * Return whether the field 'payload.Ru_Hc' is an array (false).
     */
    public static boolean isArray_payload_Ru_Hc() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'payload.Ru_Hc'
     */
    public static int offset_payload_Ru_Hc() {
        return (136 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'payload.Ru_Hc'
     */
    public static int offsetBits_payload_Ru_Hc() {
        return 136;
    }

    /**
     * Return the value (as a short) of the field 'payload.Ru_Hc'
     */
    public short get_payload_Ru_Hc() {
        return (short)getSIntBEElement(offsetBits_payload_Ru_Hc(), 16);
    }

    /**
     * Set the value of the field 'payload.Ru_Hc'
     */
    public void set_payload_Ru_Hc(short value) {
        setSIntBEElement(offsetBits_payload_Ru_Hc(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'payload.Ru_Hc'
     */
    public static int size_payload_Ru_Hc() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'payload.Ru_Hc'
     */
    public static int sizeBits_payload_Ru_Hc() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: payload.Ru_Hd
    //   Field type: int
    //   Offset (bits): 152
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'payload.Ru_Hd' is signed (false).
     */
    public static boolean isSigned_payload_Ru_Hd() {
        return false;
    }

    /**
     * Return whether the field 'payload.Ru_Hd' is an array (false).
     */
    public static boolean isArray_payload_Ru_Hd() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'payload.Ru_Hd'
     */
    public static int offset_payload_Ru_Hd() {
        return (152 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'payload.Ru_Hd'
     */
    public static int offsetBits_payload_Ru_Hd() {
        return 152;
    }

    /**
     * Return the value (as a int) of the field 'payload.Ru_Hd'
     */
    public int get_payload_Ru_Hd() {
        return (int)getSIntBEElement(offsetBits_payload_Ru_Hd(), 32);
    }

    /**
     * Set the value of the field 'payload.Ru_Hd'
     */
    public void set_payload_Ru_Hd(int value) {
        setSIntBEElement(offsetBits_payload_Ru_Hd(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'payload.Ru_Hd'
     */
    public static int size_payload_Ru_Hd() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'payload.Ru_Hd'
     */
    public static int sizeBits_payload_Ru_Hd() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: payload.Ru_Hi
    //   Field type: short
    //   Offset (bits): 184
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'payload.Ru_Hi' is signed (false).
     */
    public static boolean isSigned_payload_Ru_Hi() {
        return false;
    }

    /**
     * Return whether the field 'payload.Ru_Hi' is an array (false).
     */
    public static boolean isArray_payload_Ru_Hi() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'payload.Ru_Hi'
     */
    public static int offset_payload_Ru_Hi() {
        return (184 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'payload.Ru_Hi'
     */
    public static int offsetBits_payload_Ru_Hi() {
        return 184;
    }

    /**
     * Return the value (as a short) of the field 'payload.Ru_Hi'
     */
    public short get_payload_Ru_Hi() {
        return (short)getSIntBEElement(offsetBits_payload_Ru_Hi(), 16);
    }

    /**
     * Set the value of the field 'payload.Ru_Hi'
     */
    public void set_payload_Ru_Hi(short value) {
        setSIntBEElement(offsetBits_payload_Ru_Hi(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'payload.Ru_Hi'
     */
    public static int size_payload_Ru_Hi() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'payload.Ru_Hi'
     */
    public static int sizeBits_payload_Ru_Hi() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: payload.Ru_Rp
    //   Field type: short
    //   Offset (bits): 200
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'payload.Ru_Rp' is signed (false).
     */
    public static boolean isSigned_payload_Ru_Rp() {
        return false;
    }

    /**
     * Return whether the field 'payload.Ru_Rp' is an array (false).
     */
    public static boolean isArray_payload_Ru_Rp() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'payload.Ru_Rp'
     */
    public static int offset_payload_Ru_Rp() {
        return (200 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'payload.Ru_Rp'
     */
    public static int offsetBits_payload_Ru_Rp() {
        return 200;
    }

    /**
     * Return the value (as a short) of the field 'payload.Ru_Rp'
     */
    public short get_payload_Ru_Rp() {
        return (short)getSIntBEElement(offsetBits_payload_Ru_Rp(), 16);
    }

    /**
     * Set the value of the field 'payload.Ru_Rp'
     */
    public void set_payload_Ru_Rp(short value) {
        setSIntBEElement(offsetBits_payload_Ru_Rp(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'payload.Ru_Rp'
     */
    public static int size_payload_Ru_Rp() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'payload.Ru_Rp'
     */
    public static int sizeBits_payload_Ru_Rp() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: payload.Ru_Hp
    //   Field type: short
    //   Offset (bits): 216
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'payload.Ru_Hp' is signed (false).
     */
    public static boolean isSigned_payload_Ru_Hp() {
        return false;
    }

    /**
     * Return whether the field 'payload.Ru_Hp' is an array (false).
     */
    public static boolean isArray_payload_Ru_Hp() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'payload.Ru_Hp'
     */
    public static int offset_payload_Ru_Hp() {
        return (216 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'payload.Ru_Hp'
     */
    public static int offsetBits_payload_Ru_Hp() {
        return 216;
    }

    /**
     * Return the value (as a short) of the field 'payload.Ru_Hp'
     */
    public short get_payload_Ru_Hp() {
        return (short)getSIntBEElement(offsetBits_payload_Ru_Hp(), 16);
    }

    /**
     * Set the value of the field 'payload.Ru_Hp'
     */
    public void set_payload_Ru_Hp(short value) {
        setSIntBEElement(offsetBits_payload_Ru_Hp(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'payload.Ru_Hp'
     */
    public static int size_payload_Ru_Hp() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'payload.Ru_Hp'
     */
    public static int sizeBits_payload_Ru_Hp() {
        return 16;
    }

}