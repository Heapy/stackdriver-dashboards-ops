package io.heapy.gcp.stackdriver.dashboards

/**
 * Represents Stackdriver dashboard
 *
 * @author Ruslan Ibragimov
 * @since 1.0.0
 */
data class Dashboard(
    /**
     * The resource name of the dashboard.
     */
    val name: String,
    /**
     * The mutable, human-readable name.
     */
    val displayName: String,
    /**
     * etag is used for optimistic concurrency control as a way to help prevent
     * simultaneous updates of a policy from overwriting each other.
     * An etag is returned in the response to dashboards.get, and users
     * are expected to put that etag in the request to dashboards.patch
     * to ensure that their change will be applied to the same version of
     * the Dashboard configuration.
     * The field should not be passed during dashboard creation.
     */
    val etag: String?,

    val layout: Layout,
    val gridLayout: GridLayout,
    val rowLayout: RowLayout,
    val columnLayout: ColumnLayout
)

interface Layout

data class GridLayout(
    val columns: String,
    val widgets: List<Widget>
) : Layout

data class RowLayout(
    val rows: List<Row>
) : Layout

class ColumnLayout(
    val columns: List<Column>
) : Layout

data class Column(
    val weight: String,
    val widgets: List<Widget>
)

data class Row(
    val weight: String,
    val widgets: List<Widget>
)

class Widget
