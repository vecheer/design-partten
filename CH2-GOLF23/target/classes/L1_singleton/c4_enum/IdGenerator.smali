.class public final enum LL1_singleton/c4_enum/IdGenerator;
.super Ljava/lang/Enum;
.source "IdGenerator.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "LL1_singleton/c4_enum/IdGenerator;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[LL1_singleton/c4_enum/IdGenerator;

.field public static final enum instance:LL1_singleton/c4_enum/IdGenerator;


# instance fields
.field private final id:Ljava/util/concurrent/atomic/AtomicLong;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    const/4 v2, 0x0

    .line 11
    new-instance v0, LL1_singleton/c4_enum/IdGenerator;

    const-string v1, "instance"

    invoke-direct {v0, v1, v2}, LL1_singleton/c4_enum/IdGenerator;-><init>(Ljava/lang/String;I)V

    sput-object v0, LL1_singleton/c4_enum/IdGenerator;->instance:LL1_singleton/c4_enum/IdGenerator;

    .line 10
    const/4 v0, 0x1

    new-array v0, v0, [LL1_singleton/c4_enum/IdGenerator;

    sget-object v1, LL1_singleton/c4_enum/IdGenerator;->instance:LL1_singleton/c4_enum/IdGenerator;

    aput-object v1, v0, v2

    sput-object v0, LL1_singleton/c4_enum/IdGenerator;->$VALUES:[LL1_singleton/c4_enum/IdGenerator;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 13
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    const-wide/16 v2, 0x0

    invoke-direct {v0, v2, v3}, Ljava/util/concurrent/atomic/AtomicLong;-><init>(J)V

    iput-object v0, p0, LL1_singleton/c4_enum/IdGenerator;->id:Ljava/util/concurrent/atomic/AtomicLong;

    return-void
.end method

.method public static getInstance()LL1_singleton/c4_enum/IdGenerator;
    .registers 1

    .prologue
    .line 16
    sget-object v0, LL1_singleton/c4_enum/IdGenerator;->instance:LL1_singleton/c4_enum/IdGenerator;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)LL1_singleton/c4_enum/IdGenerator;
    .registers 2
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, LL1_singleton/c4_enum/IdGenerator;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, LL1_singleton/c4_enum/IdGenerator;

    return-object v0
.end method

.method public static values()[LL1_singleton/c4_enum/IdGenerator;
    .registers 1

    .prologue
    .line 10
    sget-object v0, LL1_singleton/c4_enum/IdGenerator;->$VALUES:[LL1_singleton/c4_enum/IdGenerator;

    invoke-virtual {v0}, [LL1_singleton/c4_enum/IdGenerator;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [LL1_singleton/c4_enum/IdGenerator;

    return-object v0
.end method


# virtual methods
.method public getId()J
    .registers 3

    .prologue
    .line 20
    iget-object v0, p0, LL1_singleton/c4_enum/IdGenerator;->id:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->getAndIncrement()J

    move-result-wide v0

    return-wide v0
.end method
