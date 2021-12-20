package $

{package.Controller};

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

#if(${restControllerStyle})

        #else
import org.springframework.stereotype.Controller;
#end

        #if(${superControllerClassPackage})
import ${superControllerClassPackage};
        #end
import java.util.List;

/**
 * @author ${author}
 * @date ${date}
 */
@Slf4j
@Api(tags = {"$!{table.comment}"})
#if(${restControllerStyle})
@RestController
#else
@Controller
#end
@RequestMapping("#if(${package.ModuleName})/${package.ModuleName}#end/#if(${controllerMappingHyphenStyle})${controllerMappingHyphen}#else${table.entityPath}#end")
#if(${kotlin})

class $ {
    table.controllerName
}#if(${superControllerClass}):${superControllerClass}()#end

        #else
        #if(${superControllerClass})

public class $ {
    table.controllerName
} extends ${superControllerClass}{
        #else

public class $ {
    table.controllerName
} {
        #end

@Autowired
public ${table.serviceName}${table.entityPath}Service;

@ApiOperation(value = "新增")
@PostMapping("/save")
public Object save(@RequestBody ${entity}${table.entityPath}){
        boolean b=${table.entityPath}Service.save(${table.entityPath});
        return b;
        }

@ApiOperation(value = "根据id删除")
@PostMapping("/delete/{id}")
public Object delete(@PathVariable("id") Long id){
        boolean b=${table.entityPath}Service.removeById(id);
        return b;
        }

@ApiOperation(value = "批量删除")
@PostMapping("/delete/batch")
public Object deleteBatch(@RequestBody String ids){
        List<Long> idList=(List<Long>)JSON.parse(ids);
        boolean b=${table.entityPath}Service.removeByIds(idList);
        return b;
        }

@ApiOperation(value = "列表（分页）")
@GetMapping("/list")
public Object list(Long pageNum,Long pageSize){
        IPage<${entity}>page=${table.entityPath}Service.page(
        new Page<>(pageNum,pageSize),
        new LambdaQueryWrapper<${entity}>().eq(false,${entity}::getId,0));
        return page;
        }

@ApiOperation(value = "详情")
@GetMapping("/get/{id}")
public Object get(@PathVariable("id") Long id){
        ${entity}${table.entityPath}=${table.entityPath}Service.getById(id);
        return ${table.entityPath};
        }

@ApiOperation(value = "根据id修改")
@PostMapping("/update/{id}")
public Object update(@PathVariable("id") Long id,@RequestBody ${entity}${table.entityPath}){
        ${table.entityPath}.setId(id);
        boolean b=${table.entityPath}Service.updateById(${table.entityPath});
        return b;
        }

@ApiOperation(value = "批量修改")
@PostMapping("/update/batch")
public Object updateBatch(@RequestBody String ${table.entityPath}s){
        List<${entity}>${table.entityPath}List=(List<${entity}>)JSON.parse(${table.entityPath}s);
        boolean b=${table.entityPath}Service.updateBatchById(${table.entityPath}List);
        return b;
        }

        #end
        }