import com.alibaba.druid.pool.DruidDataSource
import org.lenovo.conf.DbContextHolder
import org.lenovo.conf.ReadWriteSplitRoutingDataSource

def dataSourceMaster = new DruidDataSource()
dataSourceMaster.url = properties.get('jdbc:mysql://192.168.3.102:3306/bams?characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=true')
println("master set to " + dataSourceMaster.url)
dataSourceMaster.username = properties.get('root')
dataSourceMaster.password = properties.get('root')

def dataSourceSlave = new DruidDataSource()
dataSourceSlave.url = properties.get('jdbc:mysql://192.168.3.102:3307/bams?characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=true')
println("slave set to " + dataSourceSlave.url)
dataSourceSlave.username = properties.get('root')
dataSourceSlave.password = properties.get('root')
beans {
    dataSource(ReadWriteSplitRoutingDataSource) { bean ->
        targetDataSources = [
                (DbContextHolder.DbType.MASTER): dataSourceMaster,
                (DbContextHolder.DbType.SLAVE): dataSourceSlave
        ]
    }
}