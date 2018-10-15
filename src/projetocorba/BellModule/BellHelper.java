package BellModule;


/**
* BellModule/BellHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from BellModuleIDL.idl
* Domingo, 14 de Outubro de 2018 18h12min37s GMT-03:00
*/

abstract public class BellHelper
{
  private static String  _id = "IDL:BellModule/Bell:1.0";

  public static void insert (org.omg.CORBA.Any a, BellModule.Bell that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static BellModule.Bell extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (BellModule.BellHelper.id (), "Bell");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static BellModule.Bell read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_BellStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, BellModule.Bell value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static BellModule.Bell narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof BellModule.Bell)
      return (BellModule.Bell)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      BellModule._BellStub stub = new BellModule._BellStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static BellModule.Bell unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof BellModule.Bell)
      return (BellModule.Bell)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      BellModule._BellStub stub = new BellModule._BellStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
